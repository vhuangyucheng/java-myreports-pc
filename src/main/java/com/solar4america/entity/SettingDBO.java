

package com.solar4america.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

import static org.eclipse.milo.opcua.stack.core.Identifiers.IdType;

@Data
@TableName("setting")
public class SettingDBO {
    @TableId(value = "setting_id", type = com.baomidou.mybatisplus.annotation.IdType.AUTO)
    private Integer settingId;
    @TableField("initialWip")
    private Integer initialWip;
    @TableField("laminator")
    private Integer laminator;
    @TableField("current_wo")
    private String currentWo;

}
