package com.example.demo.dto;

import org.springframework.modulith.events.Externalized;

import java.time.Instant;

@Externalized("processing.completed::#{startDateTime()}")
public record OutputEvent(Instant startDateTime) {
}
