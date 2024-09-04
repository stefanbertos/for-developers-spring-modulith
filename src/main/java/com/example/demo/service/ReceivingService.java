package com.example.demo.service;

import com.example.demo.dto.LegacyEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReceivingService {
    private final ApplicationEventPublisher applicationEventPublisher;

    public void process(LegacyEvent legacyEvent) {
        log.info("Received legacy event: {}", legacyEvent);
        applicationEventPublisher.publishEvent(legacyEvent);
    }
}
