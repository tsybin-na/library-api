package ru.tsybin.na.api.library.exception.dto;

import lombok.Getter;
import lombok.Setter;
import ru.tsybin.na.api.library.exception.code.ErrorCode;

@Getter
@Setter
public class AppExceptionDto {
    private ErrorCode Code;
    private String message;
}
