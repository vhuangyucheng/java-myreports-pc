package com.solar4america.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("schedule")
public class ScheduleDBO {
    @TableId(value = "schedule_id", type= com.baomidou.mybatisplus.annotation.IdType.AUTO)
    private Integer scheduleId;
    @TableField("layup1")
    private Integer layup1;
    @TableField("layup2")
    private Integer layup2;
    @TableField("layup3")
    private Integer layup3;
    @TableField("layup4")
    private Integer layup4;
    @TableField("layup5")
    private Integer layup5;
    @TableField("layup6")
    private Integer layup6;
    @TableField("layup7")
    private Integer layup7;
    @TableField("firstel1")
    private Integer firstel1;
    @TableField("firstel2")
    private Integer firstel2;
    @TableField("firstel3")
    private Integer firstel3;
    @TableField("firstel4")
    private Integer firstel4;
    @TableField("firstel5")
    private Integer firstel5;
    @TableField("firstel6")
    private Integer firstel6;
    @TableField("firstel7")
    private Integer firstel7;
    @TableField("framing3")
    private Integer framing3;
    @TableField("framing2")
    private Integer framing2;
    @TableField("framing4")
    private Integer framing4;
    @TableField("framing5")
    private Integer framing5;
    @TableField("framing6")
    private Integer framing6;
    @TableField("framing7")
    private Integer framing7;
    @TableField("framing1")
    private Integer framing1;
    @TableField("sorting1")
    private Integer sorting1;
    @TableField("sorting2")
    private Integer sorting2;
    @TableField("sorting3")
    private Integer sorting3;
    @TableField("sorting4")
    private Integer sorting4;
    @TableField("sorting5")
    private Integer sorting5;
    @TableField("sorting6")
    private Integer sorting6;
    @TableField("sorting7")
    private Integer sorting7;
    @TableField("packing1")
    private Integer packing1;
    @TableField("packing2")
    private Integer packing2;
    @TableField("packing3")
    private Integer packing3;
    @TableField("packing4")
    private Integer packing4;
    @TableField("packing5")
    private Integer packing5;
    @TableField("packing6")
    private Integer packing6;
    @TableField("packing7")
    private Integer packing7;

    @TableField("layup_hourly1")
    private String layupHourly1;
    @TableField("layup_hourly2")
    private String layupHourly2;
    @TableField("layup_hourly3")
    private String layupHourly3;
    @TableField("layup_hourly4")
    private String layupHourly4;
    @TableField("layup_hourly5")
    private String layupHourly5;
    @TableField("layup_hourly6")
    private String layupHourly6;
    @TableField("layup_hourly7")
    private String layupHourly7;

    @TableField("firstel_hourly1")
    private String firstelHourly1;
    @TableField("firstel_hourly2")
    private String firstelHourly2;
    @TableField("firstel_hourly3")
    private String firstelHourly3;
    @TableField("firstel_hourly4")
    private String firstelHourly4;
    @TableField("firstel_hourly5")
    private String firstelHourly5;
    @TableField("firstel_hourly6")
    private String firstelHourly6;
    @TableField("firstel_hourly7")
    private String firstelHourly7;

    @TableField("framing_hourly1")
    private String framingHourly1;
    @TableField("framing_hourly2")
    private String framingHourly2;
    @TableField("framing_hourly3")
    private String framingHourly3;
    @TableField("framing_hourly4")
    private String framingHourly4;
    @TableField("framing_hourly5")
    private String framingHourly5;
    @TableField("framing_hourly6")
    private String framingHourly6;
    @TableField("framing_hourly7")
    private String framingHourly7;

    @TableField("sorting_hourly1")
    private String sortingHourly1;
    @TableField("sorting_hourly2")
    private String sortingHourly2;
    @TableField("sorting_hourly3")
    private String sortingHourly3;
    @TableField("sorting_hourly6")
    private String sortingHourly6;
    @TableField("sorting_hourly4")
    private String sortingHourly4;
    @TableField("sorting_hourly5")
    private String sortingHourly5;
    @TableField("sorting_hourly7")
    private String sortingHourly7;

    @TableField("packing_hourly1")
    private String packingHourly1;
    @TableField("packing_hourly2")
    private String packingHourly2;
    @TableField("packing_hourly3")
    private String packingHourly3;
    @TableField("packing_hourly4")
    private String packingHourly4;
    @TableField("packing_hourly5")
    private String packingHourly5;
    @TableField("packing_hourly6")
    private String packingHourly6;
    @TableField("packing_hourly7")
    private String packingHourly7;

}