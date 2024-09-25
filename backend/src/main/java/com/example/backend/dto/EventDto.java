package com.example.backend.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.backend.pojo.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto extends Event {
    /**
     * 活动名称
     */
    private String name;

    /**
     * 创建日期
     */
    private Date create_at;

    /**
     * 开始日期
     */
    private Date start_time;

    /**
     * 结束日期
     */
    private Date end_time;

    /**
     * 活动备注
     */
    private String comment;

    /**
     * 活动状态
     */
    private int status;

    /**
     * 将一个Game对象转换为 EventDto 对象。EventDto 对象通常用于在不同层之间传输数据，它只包含必要的数据，而不包含业务逻辑。
     */
    public EventDto(Event event){
        this.setName(event.getName());
        this.setCreate_at(event.getCreateAt());
        this.setStart_time(event.getStartAt());
        this.setEnd_time(event.getEndAt());
        this.setComment(event.getComment());
        this.setStatus(event.getStatus());
    }
}
