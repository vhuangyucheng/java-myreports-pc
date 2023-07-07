package com.solar4america.test;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfig;
import org.eclipse.milo.opcua.sdk.client.api.identity.UsernameProvider;
import org.eclipse.milo.opcua.sdk.client.nodes.UaVariableNode;
import org.eclipse.milo.opcua.stack.core.AttributeId;
import org.eclipse.milo.opcua.stack.core.security.SecurityPolicy;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadValueId;
import org.springframework.boot.SpringApplication;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        String day = dayFormat.format(new Date());
        System.out.println("day: " + day);

        SimpleDateFormat sdf = new SimpleDateFormat(day + " HH:mm:ss");
        Date date1 = sdf.parse(day + " 06:45:00");
        Date date2 = sdf.parse(day + " 15:15:00");
        Date date3 = sdf.parse(day + " 23:30:00");
        Date now = new Date();
        Date fake = sdf.parse(day + " 15:17:00");


        if (fake.after(date1) && fake.before(date2) || fake.equals(date1)) {
            System.out.println("Date1 ");
        }

        if (fake.after(date2) && fake.before(date3) || fake.equals(date2)) {
            System.out.println("Date2");
        }

        if (date1.after(date3)|| fake.equals(date3)) {
            System.out.println("Date3");
        }


    }
}
