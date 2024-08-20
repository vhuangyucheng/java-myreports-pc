package com.solar4america.uiltility;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solar4america.entity.SettingDBO;
import com.solar4america.service.kpi.api.IShiftRecordApi;
import com.solar4america.service.kpi.impl.ShiftRecordService;
import com.solar4america.service.setting.api.ISettingApi;
import com.solar4america.service.setting.impl.SettingService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Component
public class Leftover {

    @Autowired
    public ISettingApi settingApi;

    private static final String BASE_URL = "http://10.10.140.251:62000/api/services/MES2RPT/ProductionReportData/GetSummaryDataList";

    private String fetchJsonResponse() {
        try {
            // Define the dates
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate currentDay = LocalDate.now();
            LocalDate tomorrowDay = currentDay.plus(1, ChronoUnit.DAYS);

            String startTime = currentDay.format(formatter) + " 00:01:00";
            String endTime = tomorrowDay.format(formatter) + " 00:01:00";

            // Encode parameters
            String encodedStartTime = URLEncoder.encode(startTime, StandardCharsets.UTF_8.toString());
            String encodedEndTime = URLEncoder.encode(endTime, StandardCharsets.UTF_8.toString());
            String encodedLineCodes = URLEncoder.encode("SJC01-01", StandardCharsets.UTF_8.toString());

            // Build the URL with query parameters
            String url = String.format("%s?StartTime=%s&EndTime=%s&TimesFlag=7&MaxResultCount=1000&LineCodes=%s",
                    BASE_URL, encodedStartTime, encodedEndTime, encodedLineCodes);

            // Create the HttpClient
            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                // Create the HttpGet request
                HttpGet httpGet = new HttpGet(url);
                httpGet.setHeader("Content-Type", "application/json");

                // Execute the request
                try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                    // Get the response entity
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        // Return the response body as a string
                        return EntityUtils.toString(entity);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error fetching JSON response: " + e.getMessage());
        }
        return null;
    }

    private  int processJsonResponse(String jsonResponse) {
        try {
            // Parse JSON response
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonResponse);

            // Extract items array
            JsonNode items = rootNode.path("result").path("items");

            int Lamination = 0;
            int totalFramingJB = 0;

            // Iterate over items and sum Lamination and Framing&JB values
            for (JsonNode item : items) {
                Lamination += item.path("Lamination").asInt();
                totalFramingJB += item.path("Framing&JB").asInt();
            }

            // Calculate the result
            int resultAmount = Lamination - totalFramingJB;

            // Print the result
            return resultAmount;

        } catch (IOException e) {
            System.err.println("Error processing JSON response: " + e.getMessage());
        }
        return 0;

    }

    public void ServiceExecute(){
        String jsonResponse = fetchJsonResponse();
        int total = 0;
        if (jsonResponse != null) {
            total = processJsonResponse(jsonResponse);
        }
        SettingDBO settingDBO = settingApi.getSetting();
        settingDBO.setInitialWip(total + settingDBO.getInitialWip());
        settingApi.setSetting(settingDBO);
    }
}
