package com.solar4america.controller;


import com.solar4america.stringerClient.Line2;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.nodes.UaVariableNode;
import org.eclipse.milo.opcua.stack.core.AttributeId;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequestMapping("/stringer")
public class StringerController {

    @Autowired
    OpcUaClient String21Client;
    @Autowired
    OpcUaClient String22Client;
    @Autowired
    OpcUaClient String23Client;

    private Line2 line2 = Line2.getInstance();

    @PostMapping("/EL")
    public String stringerEL() {
        return "test";
    }

    @PostMapping("/getLine2Data")
    public String getLine2Data() {
        return "test";
    }

    @PostMapping("/test")
    public String listMachine() {
        return "test";
    }

    @PostMapping("/getString21")
    public Map<String, Object> getString01() {

        Map<String, Object> returnJson = new HashMap<>();
        returnJson.put("go", line2);

        return returnJson;


    }

    @PostMapping("/getString22")
    public Map<String, Object> getString22() {
        try {
            Map<String, Object> returnJson = new HashMap<>();
            String22Client.connect().get();
            UaVariableNode OKStringA = (UaVariableNode) String22Client.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.OKStringA"));
            returnJson.put("OKStringA", OKStringA.getValue().getValue().getValue());
            UaVariableNode NGStringA = (UaVariableNode) String22Client.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.NGStringA"));
            returnJson.put("NGStringA", NGStringA.getValue().getValue().getValue());
            UaVariableNode NGCellsA = (UaVariableNode) String22Client.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.NGCellsA"));
            returnJson.put("NGCellsA", NGCellsA.getValue().getValue().getValue());
            UaVariableNode OKStringB = (UaVariableNode) String22Client.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.OKStringB"));
            returnJson.put("OKStringB", OKStringB.getValue().getValue().getValue());
            UaVariableNode NGStringB = (UaVariableNode) String22Client.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.NGStringB"));
            returnJson.put("NGStringB", NGStringB.getValue().getValue().getValue());
            UaVariableNode NGCellsB = (UaVariableNode) String22Client.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.NGCellsB"));
            returnJson.put("NGCellsB", NGCellsB.getValue().getValue().getValue());


            return returnJson;
        } catch (UaException | ExecutionException | InterruptedException e) {
            System.out.println("calling string21" + e.toString());
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/getString23")
    public Map<String, Object> getString23() {
        try {
            Map<String, Object> returnJson = new HashMap<>();
            String23Client.connect().get();
            UaVariableNode OKStringA = (UaVariableNode) String23Client.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.OKStringA"));
            returnJson.put("OKStringA", OKStringA.getValue().getValue().getValue());
            UaVariableNode NGStringA = (UaVariableNode) String23Client.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.NGStringA"));
            returnJson.put("NGStringA", NGStringA.getValue().getValue().getValue());
            UaVariableNode NGCellsA = (UaVariableNode) String23Client.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.NGCellsA"));
            returnJson.put("NGCellsA", NGCellsA.getValue().getValue().getValue());
            UaVariableNode OKStringB = (UaVariableNode) String23Client.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.OKStringB"));
            returnJson.put("OKStringB", OKStringB.getValue().getValue().getValue());
            UaVariableNode NGStringB = (UaVariableNode) String23Client.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.NGStringB"));
            returnJson.put("NGStringB", NGStringB.getValue().getValue().getValue());
            UaVariableNode NGCellsB = (UaVariableNode) String23Client.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.NGCellsB"));
            returnJson.put("NGCellsB", NGCellsB.getValue().getValue().getValue());


            return returnJson;
        } catch (UaException | ExecutionException | InterruptedException e) {
            System.out.println("calling string21" + e.toString());
            throw new RuntimeException(e);
        }
    }
}
