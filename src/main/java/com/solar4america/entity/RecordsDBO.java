package com.solar4america.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

import static org.eclipse.milo.opcua.stack.core.Identifiers.IdType;

@Data
@TableName("record")
public class RecordsDBO {
    @TableId(value = "record_id", type= com.baomidou.mybatisplus.annotation.IdType.AUTO)
    private Integer recordId;
    @TableField("shift_id")
    private Integer shiftId;
    @TableField("is_lock")
    private Integer isLock;
    @TableField("qrcode_start")
    private String qrcodeStart;
    @TableField("qrcode_end")
    private String qrcodeEnd;
    @TableField("qrcode_amount")
    private String qrcodeAmount;
    @TableField("firstEL_output")
    private String firstELOutput;
    @TableField("firstEL_defect")
    private String firstELDefect;
    @TableField("module_repair")
    private String moduleRepair;
    @TableField("module_scrap")
    private String moduleScrap;
    @TableField("string_repair")
    private String stringRepair;
    @TableField("string_scrap")
    private String stringScrap;
    @TableField("repair_cells_receive")
    private String repairCellsReceive;
    @TableField("visual_inspection")
    private String visualInspection;
    @TableField("visual_inspection_defect")
    private String visualInspectionDefect;
    @TableField("framing")
    private String framing;
    @TableField("framing_defect")
    private String framingDefect;
    @TableField("jbox_welding")
    private String jboxWelding;
    @TableField("jbox_welding_defect")
    private String jboxWeldingDefect;
    @TableField("cleaning")
    private String cleaning;
    @TableField("cleaning_defect")
    private String cleaningDefect;
    @TableField("secondEL")
    private String secondEL;
    @TableField("secondEL_defect")
    private String secondELDefect;
    @TableField("stringer1")
    private String stringer1;
    @TableField("stringer1_defect")
    private String stringer1Defect;
    @TableField("stringer2")
    private String stringer2;
    @TableField("stringer2_defect")
    private String stringer2Defect;
    @TableField("stringer3")
    private String stringer3;
    @TableField("stringer3_defect")
    private String stringer3Defect;
    @TableField("openbox_broken")
    private String openboxBroken;
    @TableField("stringer_broken_cells")
    private String stringerBrokenCells;
    @TableField("cells_input")
    private String cellsInput;
    @TableField("panel_scrap")
    private String panelScrap;
}
