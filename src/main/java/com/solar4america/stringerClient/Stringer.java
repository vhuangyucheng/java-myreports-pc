package com.solar4america.stringerClient;

import lombok.Data;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.nodes.UaVariableNode;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;

@Data
public class Stringer {
    private OpcUaClient opcUaClient;

    private Shift shift1 = new Shift();
    private Shift shift2 = new Shift();
    private Shift shift3 = new Shift();
    private Shift currentShift;

    public void getData() throws Exception {
        UaVariableNode OKStringA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.OKStringA"));
        currentShift.setOKStringA(Integer.parseInt(OKStringA.getValue().getValue().getValue().toString()));
        UaVariableNode NGStringA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.NGStringA"));
        currentShift.setNGStringA(Integer.parseInt(NGStringA.getValue().getValue().getValue().toString()));
        UaVariableNode NGCellsA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.NGCellsA"));
        currentShift.setNGCellA(Integer.parseInt(NGCellsA.getValue().getValue().getValue().toString()));
        UaVariableNode OKStringB = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.OKStringB"));
        currentShift.setOKStringB(Integer.parseInt(OKStringB.getValue().getValue().getValue().toString()));
        UaVariableNode NGStringB = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.NGStringB"));
        currentShift.setNGStringB(Integer.parseInt(NGStringB.getValue().getValue().getValue().toString()));
        UaVariableNode NGCellsB = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.NGCellsB"));
        currentShift.setNGCellB(Integer.parseInt(NGCellsB.getValue().getValue().getValue().toString()));
    }

    public void setCurrentShift(int shiftCode) {
        switch (shiftCode) {
            case 1:
                currentShift = shift1;
                break;
            case 2:
                currentShift = shift2;
                break;
            case 3:
                currentShift = shift3;
                break;
        }
    }
}
