package com.example.demo.converter;

import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.util.Date;

@ReadingConverter
public class DateToDateTimeConverter implements Converter<Date, DateTime> {
    @Override
    public DateTime convert(Date source) {
        return new DateTime(source);
    }
}