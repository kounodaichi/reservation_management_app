package com.example.calendar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.calendar.service.EventService;

@Controller
@RequestMapping("/calendar1/calendar")
public class CalendarController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public String getCalendar(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "Calendar/calendar";
    }
}
