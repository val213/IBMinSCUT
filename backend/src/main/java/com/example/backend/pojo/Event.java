package com.example.backend.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "event")
public class Event implements Serializable {
    /**
     * 活动ID
     */
    @TableId("id")
    private String id;

    /**
     * 活动名称
     */
    @TableField("name")
    private String name;

    /**
     * 创建日期
     */
    @TableField("create_at")
    private Date create_at;

    /**
     * 开始日期
     */
    @TableField("start_time")
    private Date start_time;

    /**
     * 结束日期
     */
    @TableField("end_time")
    private Date end_time;

    /**
     * 活动备注
     */
    @TableField("comment")
    private String comment;

    /**
     * 活动状态
     */
    @TableField("status")
    private int status;

    // 定义状态和INT值的映射
    public static final int STATUS_NOT_STARTED = 0;
    public static final int STATUS_IN_PROGRESS = 1;
    public static final int STATUS_ENDED = 2;
}
