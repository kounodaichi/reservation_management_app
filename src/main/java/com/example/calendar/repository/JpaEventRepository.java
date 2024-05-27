package com.example.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.calendar.model.Event;

public interface JpaEventRepository extends JpaRepository<Event, Long> {
    // 追加のクエリメソッドがあればここに追加
}
