package com.example.demo.service;

import com.example.demo.dto.LegacyEvent;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StartupService {
    private final ReceivingService receivingService;

    @EventListener
    public void startup(ApplicationStartedEvent ignored) {
        receivingService.process(new LegacyEvent(UUID.randomUUID().toString(), new DateTime()));
    }
}
