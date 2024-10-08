package com.solar4america.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Test {

    private static final String BASE_URL = "http://10.10.140.251:62000/api/services/MES2RPT/ProductionReportData/GetSummaryDataList";

    public static void main(String[] args) {
        String jsonResponse = fetchJsonResponse();
        if (jsonResponse != null) {
            processJsonResponse(jsonResponse);
        }
    }

    private static String fetchJsonResponse() {
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

    private static void processJsonResponse(String jsonResponse) {
        try {
            // Parse JSON response
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonResponse);

            // Extract items array
            JsonNode items = rootNode.path("result").path("items");

            int totalEL1 = 0;
            int totalFramingJB = 0;

            // Iterate over items and sum EL-1 and Framing&JB values
            for (JsonNode item : items) {
                totalEL1 += item.path("EL-1").asInt();
                totalFramingJB += item.path("Framing&JB").asInt();
            }

            // Calculate the result
            int resultAmount = totalEL1 - totalFramingJB;

            // Print the result
            System.out.println("Result: " + resultAmount);

        } catch (IOException e) {
            System.err.println("Error processing JSON response: " + e.getMessage());
        }
    }
}
