package ru.tsybin.na.api.library.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Getter
@Setter
@Component
@ConfigurationProperties("app")
public class AppProperties {

    private Locale locale;

}
