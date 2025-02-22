package com.solar4america.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("wo")
public class WoDBO {
    @TableId(value = "wo_id", type = com.baomidou.mybatisplus.annotation.IdType.AUTO)
    private Integer woId;
    @TableField("wo_name")
    private String woName;


}