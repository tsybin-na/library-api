package ru.tsybin.na.api.library.controller.mvc;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {

    @GetMapping
    public String indexAction() {
        return "index";
    }

}
