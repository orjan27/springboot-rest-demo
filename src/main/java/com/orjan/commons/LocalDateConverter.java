package com.orjan.commons;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {
  @Override
  public Date convertToDatabaseColumn(LocalDate localDateTime) {
    return Optional.ofNullable(localDateTime)
        .map(Date::valueOf)
        .orElse(null);
  }
  @Override
  public LocalDate convertToEntityAttribute(Date timestamp) {
    return Optional.ofNullable(timestamp)
        .map(Date::toLocalDate)
        .orElse(null);
  }
}