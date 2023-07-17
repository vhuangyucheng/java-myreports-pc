package com.solar4america.stringerClient;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.nodes.UaVariableNode;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;

@Data
@RequiredArgsConstructor
public class Stringer {
    private transient OpcUaClient opcUaClient;
    @NonNull
    private String StringerName;
    private Shift shift1 = new Shift("Day");
    private Shift shift2 = new Shift("Night");
    private Shift shift3 = new Shift("NN");
//    private List<Shift> shiftList = Lists.newArrayList(shift1, shift2,shift3);
    private Shift currentShift;

    public void getData() throws Exception {
        //刷新当班data，打包三个shift
        //okstring, ngstring, ngcell
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
        //故障时间
        UaVariableNode autoFaultTimeA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Leo_OEE.ExportTime.AutoFaultTime_A"));
        currentShift.setAutoFaultTimeA(Integer.parseInt(autoFaultTimeA.getValue().getValue().getValue().toString()));
        UaVariableNode autoFaultTimeB = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Leo_OEE.ExportTime.AutoFaultTime_B"));
        currentShift.setAutoFaultTimeB(Integer.parseInt(autoFaultTimeB.getValue().getValue().getValue().toString()));
        //缺料时间
        UaVariableNode autoMissingMaterialTimeA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Leo_OEE.ExportTime.AutoMissingMaterialTime_A"));
        currentShift.setAutoMissingMaterialTimeA(Integer.parseInt(autoMissingMaterialTimeA.getValue().getValue().getValue().toString()));
        UaVariableNode autoMissingMaterialTimeB = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Leo_OEE.ExportTime.AutoMissingMaterialTime_B"));
        currentShift.setAutoMissingMaterialTimeB(Integer.parseInt(autoMissingMaterialTimeB.getValue().getValue().getValue().toString()));
        //自动运行时间
        UaVariableNode autoRunTimeA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Leo_OEE.ExportTime.AutoRunTime_A"));
        currentShift.setAutoRunTimeA(Integer.parseInt(autoRunTimeA.getValue().getValue().getValue().toString()));
        UaVariableNode autoRunTimeB = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Leo_OEE.ExportTime.AutoRunTime_B"));
        currentShift.setAutoRunTimeB(Integer.parseInt(autoRunTimeB.getValue().getValue().getValue().toString()));
        //换料
        UaVariableNode autoSuspendTimeA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Leo_OEE.ExportTime.AutoSuspendTime_A"));
        currentShift.setAutoSuspendTimeA(Integer.parseInt(autoSuspendTimeA.getValue().getValue().getValue().toString()));
        UaVariableNode autoSuspendTimeB = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Leo_OEE.ExportTime.AutoSuspendTime_B"));
        currentShift.setAutoSuspendTimeB(Integer.parseInt(autoSuspendTimeB.getValue().getValue().getValue().toString()));
        //堵料
        UaVariableNode blockTimeA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Leo_OEE.ExportTime.BlockTime_A"));
        currentShift.setBlockTimeA(Integer.parseInt(blockTimeA.getValue().getValue().getValue().toString()));
        UaVariableNode blockTimeB = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Leo_OEE.ExportTime.BlockTime_B"));
        currentShift.setBlockTimeB(Integer.parseInt(blockTimeB.getValue().getValue().getValue().toString()));
        //手动运行
        UaVariableNode manualRunTimeA = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Leo_OEE.ExportTime.ManualRunTime_A"));
        currentShift.setManualRunTimeA(Integer.parseInt(manualRunTimeA.getValue().getValue().getValue().toString()));
        UaVariableNode manualRunTimeB = (UaVariableNode) opcUaClient.getAddressSpace().getNode(new NodeId(2, "Tag.Leo_OEE.ExportTime.ManualRunTime_B"));
        currentShift.setManualRunTimeB(Integer.parseInt(manualRunTimeB.getValue().getValue().getValue().toString()));
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
