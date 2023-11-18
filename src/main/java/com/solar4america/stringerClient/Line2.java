package com.solar4america.stringerClient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solar4america.uiltility.TimeUtility;
import lombok.Data;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.security.SecurityPolicy;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;

@Data
public class Line2 implements Serializable {
    @JsonIgnore
    private static Line2 instance = new Line2();
    private Stringer stringer21 = new Stringer("string21");
    private Stringer stringer22 = new Stringer("string22");
    private Stringer stringer23 = new Stringer("string23");

    private Line2() {
        try {
            //1号
            OpcUaClient opcUaClient21 = OpcUaClient.create(
                    "opc.tcp://10.10.140.91:50000",
                    endpoints ->
                            endpoints.stream()
                                    .filter(e -> e.getSecurityPolicyUri().equals(SecurityPolicy.None.getUri()))
                                    .findFirst(),
                    OpcUaClientConfigBuilder::build
            );
            opcUaClient21.connect().get();
            stringer21.setOpcUaClient(opcUaClient21);
//            2号
            OpcUaClient opcUaClient22 = OpcUaClient.create(
                    "opc.tcp://10.10.140.92:50000",
                    endpoints ->
                            endpoints.stream()
                                    .filter(e -> e.getSecurityPolicyUri().equals(SecurityPolicy.None.getUri()))
                                    .findFirst(),
                    OpcUaClientConfigBuilder::build
            );
            opcUaClient22.connect().get();
            stringer22.setOpcUaClient(opcUaClient22);
            //3号
            OpcUaClient opcUaClient23 = OpcUaClient.create(
                    "opc.tcp://10.10.140.93:50000",
                    endpoints ->
                            endpoints.stream()
                                    .filter(e -> e.getSecurityPolicyUri().equals(SecurityPolicy.None.getUri()))
                                    .findFirst(),
                    OpcUaClientConfigBuilder::build
            );
            opcUaClient23.connect().get();
            stringer23.setOpcUaClient(opcUaClient23);
        } catch (UaException | ExecutionException | InterruptedException e) {
            System.out.println(e.toString());
            System.out.println("string21 client connection issue");
//            throw new RuntimeException(e);
        }
        //todo, 开机设置时间，但早班没有备份
        stringer21.setCurrentShift(TimeUtility.getCurrentShift());
        stringer22.setCurrentShift(TimeUtility.getCurrentShift());
        stringer23.setCurrentShift(TimeUtility.getCurrentShift());
    }

    public static Line2 getInstance() {
        return instance;
    }

    @JsonIgnore
    public Line2 getLine2DataGo() throws Exception {
        stringer21.getData();
        stringer22.getData();
        stringer23.getData();
        return instance;
    }

    @JsonIgnore
    public Line2 empty()  {
        stringer21.empty();
        stringer22.empty();
        stringer23.empty();
        return instance;
    }
}
