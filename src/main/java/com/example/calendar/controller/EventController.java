package com.example.calendar.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.calendar.model.Event;
import com.example.calendar.service.EventService;

@Controller
@RequestMapping("/calendar1/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public String getAllEvents(Model model) {
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        return "Event/event"; // テンプレートの名前を返す
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Event> getAllEventsJson() {
        return eventService.getAllEvents();
    }

    // イベントの追加
    @PostMapping
    public String addEvent(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
                           @RequestParam("description") String description,
                           @RequestParam("title") String title) {
        Event event = new Event();
        event.setDate(date);
        event.setDescription(description);
        event.setTitle(title);
        eventService.addEvent(event);
        return "redirect:/calendar1/events"; // イベント一覧ページにリダイレクト
    }

    // イベントの編集
    @PutMapping("/{eventId}/edit")
    public String editEvent(@PathVariable Long eventId, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
                            @RequestParam("description") String description,
                            @RequestParam("title") String title) {
        Event event = new Event();
        event.setId(eventId);
        event.setDate(date);
        event.setDescription(description);
        event.setTitle(title);
        eventService.editEvent(eventId, event);
        return "redirect:/calendar1/events"; // イベント一覧ページにリダイレクト
    }

    // イベントの削除
    @DeleteMapping("/{eventId}")
    public String deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return "redirect:/calendar1/events"; // 削除後にイベント一覧ページにリダイレクト
    }
}
