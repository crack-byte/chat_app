package com.crackbyte.util;

import org.springframework.data.convert.Jsr310Converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Converter(autoApply = true)
public class DateConverter implements AttributeConverter<LocalDateTime, Long> {

    @Override
    public Long convertToDatabaseColumn(LocalDateTime attribute) {
        return Jsr310Converters.LocalDateTimeToDateConverter.INSTANCE.convert(attribute).getTime();
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp),
                TimeZone.getTimeZone("UTC").toZoneId());
    }
}