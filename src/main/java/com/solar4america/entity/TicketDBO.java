package com.solar4america.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("ticket")
public class TicketDBO {
    @TableId(value = "ticket_id", type = com.baomidou.mybatisplus.annotation.IdType.AUTO)
    private Integer ticketId;
    @TableField("ticket_line")
    private Integer ticketLine;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
    @TableField("ticket_priority")
    private Integer ticketPriority;
    @TableField("ticket_status")
    private Integer ticketStatus;
    @TableField("ticket_duration")
    private Integer ticketDuration;
    @TableField("ticket_issuer")
    private Integer ticketIssuer;
    @TableField("ticket_responder")
    private Integer ticketResponder;
    @TableField("ticket_message")
    private String ticketMessage;
    @TableField("ticket_reply")
    private String ticketReply;
    @TableField("ticket_shift_id")
    private Integer ticketShiftId;



}