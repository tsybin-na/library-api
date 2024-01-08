package ru.tsybin.na.api.library.exception.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.tsybin.na.api.library.exception.EntityNotFoundException;
import ru.tsybin.na.api.library.exception.dto.AppExceptionDto;
import ru.tsybin.na.api.library.exception.dto.ValidationExceptionDto;
import ru.tsybin.na.api.library.util.MessageUtil;

import static ru.tsybin.na.api.library.exception.code.ErrorCode.ENTITY_NOT_FOUND;
import static ru.tsybin.na.api.library.exception.code.ErrorCode.VALIDATION_ERROR;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageUtil messageUtil;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public AppExceptionDto handleEntityNotFound(EntityNotFoundException ex) {
        log.warn(ex.getMessage());
        AppExceptionDto appExceptionDto = new AppExceptionDto();
        appExceptionDto.setCode(ENTITY_NOT_FOUND);
        appExceptionDto.setMessage(messageUtil.getMessage("exception.entityNotFound"));
        return appExceptionDto;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ValidationExceptionDto validationExceptionDto = new ValidationExceptionDto();
        validationExceptionDto.setCode(VALIDATION_ERROR);
        validationExceptionDto.setMessage(messageUtil.getMessage("validation.errorMessage"));
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            validationExceptionDto.addField(fieldName, errorMessage);
        });
        return new ResponseEntity<>(validationExceptionDto, HttpStatus.BAD_REQUEST);
    }

}
