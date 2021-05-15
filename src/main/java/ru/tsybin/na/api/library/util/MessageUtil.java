package ru.tsybin.na.api.library.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.tsybin.na.api.library.configuration.AppProperties;

@Component
@RequiredArgsConstructor
public class MessageUtil {

    private final MessageSource messageSource;

    private final AppProperties appProperties;

    public String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, appProperties.getLocale());
    }

}
