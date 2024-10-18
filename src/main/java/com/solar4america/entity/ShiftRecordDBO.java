package com.solar4america.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

import static org.eclipse.milo.opcua.stack.core.Identifiers.IdType;

@Data
@TableName("shift_record")
public class ShiftRecordDBO {
    @TableId(value = "shift_record_id", type = com.baomidou.mybatisplus.annotation.IdType.AUTO)
    private Integer shiftRecordId;
    @TableField("shift_id")
    private Integer shiftId;
    @TableField("is_lock")
    private Integer isLock;
    @TableField("qrcode_start")
    private String qrcodeStart;
    @TableField("qrcode_end")
    private String qrcodeEnd;
    @TableField("qrcode_start2")
    private String qrcodeStart2;
    @TableField("qrcode_end2")
    private String qrcodeEnd2;
    @TableField("qrcode_amount")
    private String qrcodeAmount;
    @TableField("glass_output")
    private String glassOutput;
    @TableField("glass_defect")
    private String glassDefect;
    @TableField("evaglass_output")
    private String evaglassOutput;
    @TableField("evaglass_defect")
    private String evaglassDefect;
    @TableField("backsheet_output")
    private String backsheetOutput;
    @TableField("backsheet_defect")
    private String backsheetDefect;
    @TableField("evabacksheet_output")
    private String evabacksheetOutput;
    @TableField("evabacksheet_defect")
    private String evabacksheetDefect;
    @TableField("high_temperature_tape_output")
    private String highTemperatureTapeOutput;
    @TableField("stringer1_output")
    private Integer stringer1Output;
    @TableField("stringer1_miswelding")
    private Integer stringer1Miswelding;
    @TableField("stringer1_overwelding")
    private Integer stringer1Overwelding;
    @TableField("stringer1_split")
    private Integer stringer1Split;
    @TableField("stringer1_crack")
    private Integer stringer1Crack;
    @TableField("stringer1_cells_crack")
    private Double stringer1CellsCrack;
    @TableField("stringer2_output")
    private Integer stringer2Output;
    @TableField("stringer2_miswelding")
    private Integer stringer2Miswelding;
    @TableField("stringer2_overwelding")
    private Integer stringer2Overwelding;
    @TableField("stringer2_split")
    private Integer stringer2Split;
    @TableField("stringer2_crack")
    private Integer stringer2Crack;
    @TableField("stringer2_cells_crack")
    private Double stringer2CellsCrack;
    @TableField("stringer3_output")
    private Integer stringer3Output;
    @TableField("stringer3_miswelding")
    private Integer stringer3Miswelding;
    @TableField("stringer3_overwelding")
    private Integer stringer3Overwelding;
    @TableField("stringer3_split")
    private Integer stringer3Split;
    @TableField("stringer3_crack")
    private Integer stringer3Crack;
    @TableField("stringer3_cells_crack")
    private Double stringer3CellsCrack;
    @TableField("bussing_output")
    private String bussingOutput;
    @TableField("bussing_miswelding")
    private String bussingMiswelding;
    @TableField("bussing_badmargin")
    private String bussingBadmargin;
    @TableField("bussing_badstringspacing")
    private String bussingBadstringspacing;
    @TableField("bussing_others")
    private String bussingOthers;
    @TableField("firstel1_output")
    private String firstel1Output;
    @TableField("firstel2_output")
    private Integer firstel2Output;
    @TableField("firstel2_defect")
    private Integer firstel2Defect;
    @TableField("cells_receive")
    private Double cellsReceive;
    @TableField("cells_input")
    private Double cellsInput;
    @TableField("stringer_scrap")
    private Double stringerScrap;
    @TableField("incoming_scrap")
    private Double incomingScrap;
    @TableField("repair_scrap")
    private Double repairScrap;
    @TableField("incident_scrap")
    private Double incidentScrap;
    @TableField("cells_left")
    private Double cellsLeft;
    @TableField("ribbon_scrap")
    private String ribbonScrap;
    @TableField("busbar_scrap")
    private String busbarScrap;
    @TableField("laminator1_output")
    private Integer laminator1Output;
    @TableField("laminator2_output")
    private String laminator2Output;
    @TableField("laminator3_output")
    private String laminator3Output;
    @TableField("trimming_output")
    private String trimmingOutput;
    @TableField("framing_output")
    private Integer framingOutput;
    @TableField("secondel_output")
    private Integer secondelOutput;
    @TableField("framing_scrap")
    private String framingScrap;
    @TableField("framing_glue_scrap")
    private String framingGlueScrap;
    @TableField("jbox_scrap")
    private String jboxScrap;
    @TableField("sealant_glue_scrap")
    private String sealantGlueScrap;
    @TableField("corner_protection_scrap")
    private String cornerProtectionScrap;
    @TableField("pallet_scrap")
    private String palletScrap;
    @TableField("packing_carton_scrap")
    private String packingCartonScrap;
    @TableField("packing_strap")
    private String packingStrap;
    @TableField("stringer1_others")
    private Integer stringer1Others;
    @TableField("stringer2_others")
    private Integer stringer2Others;
    @TableField("stringer3_others")
    private Integer stringer3Others;
    @TableField("iv_defect")
    private String ivDefect;
    @TableField("hipot_defect")
    private String hipotDefect;
    @TableField("secondel_defect")
    private String secondelDefect;
    @TableField("packing")
    private Integer packing;
    @TableField("short_frame_scrap")
    private String shortFrameScrap;
    @TableField("finishedgood_degrade")
    private Integer finishedgoodDegrade;
    @TableField("finishedgood_scrap")
    private Integer finishedgoodScrap;
    @TableField("firstel_yield_rate")
    private String firstelYieldRate;
    @TableField("stringer_yield_rate")
    private String stringerYieldRate;
    @TableField("lamination_defect")
    private Integer laminationDefect;
    @TableField("appearance_inspection")
    private Integer appearanceInspection;
    @TableField("junctionbox_defect")
    private Integer junctionboxDefect;
    @TableField("rework_output")
    private Integer reworkOutput;
    @TableField("rework_ngstring")
    private Integer reworkNgstring;
    @TableField("repair_string_scrap")
    private Double repairStringScrap;
    @TableField("shift_comment")
    private String shiftComment;
    @TableField("equipment_comment")
    private String equipmentComment;
    @TableField("qc_comment")
    private String qcComment;
    @TableField("planning_comment")
    private String planningComment;
    @TableField("wo")
    private String wo;
}
