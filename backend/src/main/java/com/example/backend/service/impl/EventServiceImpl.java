package com.example.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    public Result listEvents(){
        // 构建EventDto列表
        List<EventDto> eventDtoList = new ArrayList<>();
        // 执行查询
        List<Event> events = eventMapper.getEvents();
        for (Event event : events) {
            EventDto eventDto = new EventDto(event);
            eventDtoList.add(eventDto);
        }
        return Result.success(eventDtoList);
    }
    @Override
    public Result createEvent(){
        return Result.success();
    }
    @Override
    public Result getEventDetail(int eventId){
        return Result.success();
    }
    @Override
    public Result updateEvent(int eventId){
        return Result.success();
    }
    @Override
    public Result deleteEvent(int eventId){
        return Result.success();
    }

}