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

}