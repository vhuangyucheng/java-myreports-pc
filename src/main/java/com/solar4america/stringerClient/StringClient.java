package com.solar4america.stringerClient;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.security.SecurityPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutionException;

@Configuration
public class StringClient {
    @Bean
    public OpcUaClient String21Client() {
        try {
            OpcUaClient client = OpcUaClient.create(
                    "opc.tcp://10.10.140.91:50000",
                    endpoints ->
                            endpoints.stream()
                                    .filter(e -> e.getSecurityPolicyUri().equals(SecurityPolicy.None.getUri()))
                                    .findFirst(),
                    OpcUaClientConfigBuilder::build
            );
            client.connect().get();
            return client;
        } catch (UaException | ExecutionException | InterruptedException e) {
            System.out.println("string21 client connection issue");
            throw new RuntimeException(e);
        }
    }
    @Bean
    public OpcUaClient String22Client() {
        try {
            OpcUaClient client = OpcUaClient.create(
                    "opc.tcp://10.10.140.92:50000",
                    endpoints ->
                            endpoints.stream()
                                    .filter(e -> e.getSecurityPolicyUri().equals(SecurityPolicy.None.getUri()))
                                    .findFirst(),
                    OpcUaClientConfigBuilder::build
            );
            client.connect().get();
            return client;
        } catch (UaException | ExecutionException | InterruptedException e) {
            System.out.println("string22 client connection issue");
            throw new RuntimeException(e);
        }
    }
    @Bean
    public OpcUaClient String23Client() {
        try {
            OpcUaClient client = OpcUaClient.create(
                    "opc.tcp://10.10.140.93:50000",
                    endpoints ->
                            endpoints.stream()
                                    .filter(e -> e.getSecurityPolicyUri().equals(SecurityPolicy.None.getUri()))
                                    .findFirst(),
                    OpcUaClientConfigBuilder::build
            );
            client.connect().get();
            return client;
        } catch (UaException | ExecutionException | InterruptedException e) {
            System.out.println("string23 client connection issue");
            throw new RuntimeException(e);
        }
    }
}
