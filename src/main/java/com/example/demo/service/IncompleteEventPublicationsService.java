package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.IncompleteEventPublications;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class IncompleteEventPublicationsService {
    private final IncompleteEventPublications incompleteEventPublications;

    @Scheduled(fixedDelay = 60_000)
    public void retryFailedEvents() {
        log.info("Retrying failed events");
        incompleteEventPublications.resubmitIncompletePublications((ep) -> true);
    }
}
