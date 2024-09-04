package com.example.demo.service;

import com.example.demo.dto.LegacyEvent;
import com.example.demo.dto.OutputEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessingService {
    private final ApplicationEventPublisher applicationEventPublisher;

    @ApplicationModuleListener
    void onLegacyEvent(LegacyEvent legacyEvent) {
        log.info("Processing legacy event: {}", legacyEvent);

        applicationEventPublisher.publishEvent(new OutputEvent(Instant.ofEpochMilli(legacyEvent.getStartDateTime().getMillis())));

        //throw new RuntimeException("Something went wrong");
    }
}
