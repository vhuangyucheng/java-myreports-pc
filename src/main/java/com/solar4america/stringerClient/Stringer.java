package com.solar4america.stringerClient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.nodes.UaVariableNode;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;

import java.io.Serializable;

import static org.eclipse.milo.opcua.stack.core.BuiltinDataType.Variant;

@Data
public class Stringer implements Serializable {
    @JsonIgnore
    private OpcUaClient opcUaClient;
    private String stringerName;
    private Shift shift1;
    private Shift shift2;
    private Shift shift3;
    @JsonIgnore
    private Shift currentShift;

    public Stringer(String stringerName) {
        this.stringerName = stringerName;
        shift1 = new Shift("Day-" + stringerName);
        shift2 = new Shift("Night-" + stringerName);
        shift3 = new Shift("NN-" + stringerName);
    }

    public void getData() {
        try {
            //刷新当班data，打包三个shift
            //okstring, ngstring, ngcell
            UaVariableNode OKStringA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.OKStringA"));
            currentShift.setOKStringA(((Double) OKStringA.getValue().getValue().getValue()).intValue());
            UaVariableNode NGStringA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.NGStringA"));
            currentShift.setNGStringA(((Double) NGStringA.getValue().getValue().getValue()).intValue());
            UaVariableNode NGCellsA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.NGCellsA"));
            currentShift.setNGCellA(((Long) NGCellsA.getValue().getValue().getValue()).intValue());
            UaVariableNode OKStringB = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.OKStringB"));
            currentShift.setOKStringB(((Double) OKStringB.getValue().getValue().getValue()).intValue());
            UaVariableNode NGStringB = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.NGStringB"));
            currentShift.setNGStringB(((Double) NGStringB.getValue().getValue().getValue()).intValue());
            UaVariableNode NGCellsB = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.NGCellsB"));
            currentShift.setNGCellB(((Long) NGCellsB.getValue().getValue().getValue()).intValue());
            //故障时间
            UaVariableNode autoFaultTimeA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.ErrorTimeA"));
            shift1.setErrorTImeA((Double) autoFaultTimeA.getValue().getValue().getValue());
            UaVariableNode autoFaultTimeB = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.ErrorTimeB"));
            shift1.setErrorTImeB((Double) autoFaultTimeB.getValue().getValue().getValue());
            //缺料时间
            UaVariableNode autoMissingMaterialTimeA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.LackTimeA"));
            shift1.setLackTimeA((Double) autoMissingMaterialTimeA.getValue().getValue().getValue());
            UaVariableNode autoMissingMaterialTimeB = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.LackTimeB"));
            shift1.setLackTimeB((Double) autoMissingMaterialTimeB.getValue().getValue().getValue());
            //自动运行时间
            UaVariableNode autoRunTimeA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.RunTimeA"));
            shift1.setAutoRunTimeA((Double) autoRunTimeA.getValue().getValue().getValue());
            UaVariableNode autoRunTimeB = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.RunTimeB"));
            shift1.setAutoRunTimeB((Double) autoRunTimeB.getValue().getValue().getValue());
            //自动暂停时间
            UaVariableNode autoSuspendTimeA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.PauseTimeA"));
            shift1.setPauseTimeA((Double) autoSuspendTimeA.getValue().getValue().getValue());
            UaVariableNode autoSuspendTimeB = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.PauseTimeB"));
            shift1.setPauseTimeB((Double) autoSuspendTimeB.getValue().getValue().getValue());
            //堵料 todo 没有a
            UaVariableNode blockTimeA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.StopTime"));
            shift1.setBlockTimeA((Double) blockTimeA.getValue().getValue().getValue());
            //todo 有的机子是double有的是Long
            UaVariableNode blockTimeB = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.StopTimeB"));
//        if ((blockTimeB.getValue().getValue().getValue()) instanceof Double)
            shift1.setBlockTimeB((Double) blockTimeB.getValue().getValue().getValue());
//        if ((blockTimeB.getValue().getValue().getValue()) instanceof Long)
//            currentShift.setBlockTimeB((Long) blockTimeB.getValue().getValue().getValue());
            //手动运行
            UaVariableNode manualRunTimeA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.ManualTimeA"));
            shift1.setManualRunTimeA((Double) manualRunTimeA.getValue().getValue().getValue());
            UaVariableNode manualRunTimeB = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.ManualTimeB"));
            shift1.setManualRunTimeB((Double) manualRunTimeB.getValue().getValue().getValue());
        } catch (Exception e) {
            System.out.println("get stringer data issue, mostly connection");
            System.out.println(e.getMessage());
        }
    }

    public void clearData() {
        try {
            UaVariableNode OKStringA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Statistics.PLC.OKStringA"));
            OKStringA.setValue(new Variant(0));
        }catch (Exception e) {
            System.out.println("get stringer data issue, mostly connection");
            System.out.println(e.getMessage());
        }
    }

    public void empty() {
        shift1 = new Shift("Day-" + this.stringerName);
        shift2 = new Shift("Night-" + this.stringerName);
        shift3 = new Shift("NN-" + this.stringerName);
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
