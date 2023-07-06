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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try {
            OpcUaClient client = OpcUaClient.create(
                    "opc.tcp://10.10.140.92:50000",
                    endpoints ->
                            endpoints.stream()
                                    .filter(e -> e.getSecurityPolicyUri().equals(SecurityPolicy.None.getUri()))
                                    .findFirst(),
                    configBuilder ->
                            configBuilder.build()
            );
            client.connect().get();


            UaVariableNode testNode = (UaVariableNode) client.getAddressSpace().getNode(
                    new NodeId(2, "Tag.MES.MR2004")
            );

// Read the Value attribute
            DataValue value = testNode.readValue();

// Read the BrowseName attribute
            QualifiedName browseName = testNode.readBrowseName();

// Read the Description attribute, with timestamps and quality intact
            DataValue descriptionValue = testNode.readAttribute(AttributeId.Description);
            System.out.println(descriptionValue + "ddddddd");
            System.out.println(value + "ddddddd");
            System.out.println(browseName + "ddddddd");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
