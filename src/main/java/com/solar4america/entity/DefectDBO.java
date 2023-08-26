

package com.solar4america.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

import static org.eclipse.milo.opcua.stack.core.Identifiers.IdType;

@Data
@TableName("defect")
public class DefectDBO {
    @TableId(value = "defect_id", type = com.baomidou.mybatisplus.annotation.IdType.AUTO)
    private Integer defectId;
    @TableField("qrcode")
    private String qrcode;
    @TableField("shift_location")
    private Integer shiftLocation;
    @TableField("shift_time")
    private Integer shiftTime;
    @TableField("station")
    private String station;
    @TableField("reason")
    private String reason;
    @TableField("submitee")
    private String submitee;
    @TableField("review_date")
    private Integer reviewDate;
    @TableField("model")
    private String model;
    @TableField("mo")
    private String mo;
    @TableField("defect_location")
    private String defectLocation;
    @TableField("description")
    private String description;
    @TableField("grade")
    private String grade;
    @TableField("judger")
    private String judger;
    @TableField("remark")
    private String remark;
    @TableField("status")
    private Integer status;
}
