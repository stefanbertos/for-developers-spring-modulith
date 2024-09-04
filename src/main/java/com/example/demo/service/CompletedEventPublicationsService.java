package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.CompletedEventPublications;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CompletedEventPublicationsService {
    private final CompletedEventPublications completedEventPublications;

    @Scheduled(fixedDelay = 60_000)
    public void dumpCompletedEvents() {
        log.info("Dumping completed events {}", completedEventPublications.findAll());
    }
}
