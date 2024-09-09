package com.example.backend.service;

import com.example.backend.dto.EventDto;
import com.example.backend.pojo.Result;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

@Service
public interface EventService {
    Result listEvents();
    Result getEventDetail(int eventId);
    Result createEvent(EventDto eventdto);
    Result updateEvent(int eventId,EventDto eventdto);
    Result deleteEvent(int eventId);

}
