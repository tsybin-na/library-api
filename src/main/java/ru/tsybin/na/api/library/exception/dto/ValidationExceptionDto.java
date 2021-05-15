package ru.tsybin.na.api.library.exception.dto;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ValidationExceptionDto extends AppExceptionDto {

    private final Map<String, String> invalidFields = new HashMap<>();

    public void addField(String field, String message) {
        invalidFields.put(field, message);
    }

}
