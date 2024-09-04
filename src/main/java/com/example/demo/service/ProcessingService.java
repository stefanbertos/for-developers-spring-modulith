package com.example.demo.service;

import com.example.demo.dto.LegacyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProcessingService {
    @ApplicationModuleListener
    void onLegacyEvent(LegacyEvent legacyEvent) {
        log.info("Processing legacy event: {}", legacyEvent);

        //throw new RuntimeException("Something went wrong");
    }
}
