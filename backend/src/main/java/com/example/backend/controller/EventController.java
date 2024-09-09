package com.example.backend.controller;

import com.example.backend.dto.EventDto;
import com.example.backend.pojo.Result;
import com.example.backend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EventController {
    @Autowired
    private EventService eventService;
    @PostMapping("/events/create")
    public Result createEvent(@RequestBody EventDto eventdto) {
        return eventService.createEvent(eventdto);
    }
    @GetMapping("/events")
//    @PreAuthorized
    public Result listEvents() {
        return eventService.listEvents();
    }
    @GetMapping("/events/{eventId}")
    public Result getEventDetail(@PathVariable int eventId) {
        return eventService.getEventDetail(eventId);
    }
    @PutMapping("/events/{eventId}")
    public Result updateEvent(@PathVariable int eventId, @RequestBody EventDto eventdto) {
        return eventService.updateEvent(eventId, eventdto);
    }
    @DeleteMapping("/events/{eventId}")
    public Result deleteEvent(@PathVariable int eventId) {
        return eventService.deleteEvent(eventId);
    }
}
