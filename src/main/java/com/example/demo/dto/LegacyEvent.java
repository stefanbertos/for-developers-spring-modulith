package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.DateTime;

@Data
@AllArgsConstructor
public class LegacyEvent {
    private String id;
    private DateTime startDateTime;
}
