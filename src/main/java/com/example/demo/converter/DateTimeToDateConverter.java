package com.example.demo.converter;

import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import java.util.Date;

@WritingConverter
public class DateTimeToDateConverter implements Converter<DateTime, Date> {
    @Override
    public Date convert(DateTime source) {
        return source.toDate();
    }
}
