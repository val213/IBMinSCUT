package com.example.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.dto.EventSimpleDto;
import com.example.backend.mapper.EventMapper;
import com.example.backend.pojo.Event;
import com.example.backend.pojo.Result;
import com.example.backend.dto.EventDto;
import com.example.backend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventMapper eventMapper;
    @Override
    public Result listEvents() {
        // 执行查询
        List<Event> events = eventMapper.selectList(new QueryWrapper<>());
        // 构造一个包含事件名称和创建时间的简单列表，只包含事件名称和创建时间
        List<EventSimpleDto> eventNamesAndCreateAt = new ArrayList<>();
        for (Event event : events) {
            eventNamesAndCreateAt.add(new EventSimpleDto(event.getName(), event.getCreateAt(), event.getStatus()));
        }
        return Result.success(eventNamesAndCreateAt);
    }
    @Override
    public Result createEvent(EventDto eventdto){
        // 构建Event对象
        Event event = new Event();
        event.setName(eventdto.getName());
        event.setCreateAt(eventdto.getCreate_at());
        event.setStartAt(eventdto.getStart_time());
        event.setEndAt(eventdto.getEnd_time());
        event.setComment(eventdto.getComment());
        event.setStatus(eventdto.getStatus());
        // 执行插入
        eventMapper.insert(event);
        // 返回成功结果
        return Result.success();
    }
    @Override
    public Result getEventDetail(int eventId){
        // 执行查询
        Event event = eventMapper.selectById(eventId);
        // 构建EventDto对象
        EventDto eventDto = new EventDto(event);
        return Result.success(eventDto);
    }
    @Override
    public Result updateEvent(int eventId, EventDto eventdto){
        // 执行更新
        Event event = eventMapper.selectById(eventId);
        event.setName(eventdto.getName());
        event.setCreateAt(eventdto.getCreate_at());
        event.setStartAt(eventdto.getStart_time());
        event.setEndAt(eventdto.getEnd_time());
        event.setComment(eventdto.getComment());
        event.setStatus(eventdto.getStatus());
        eventMapper.updateById(event);
        // 返回成功结果
        return Result.success();
    }
    @Override
    public Result deleteEvent(int eventId){
        // 执行删除
        eventMapper.deleteById(eventId);
        // 返回成功结果
        return Result.success();
    }

}