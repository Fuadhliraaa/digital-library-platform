package com.portfolio.library.book.controller.dummy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class DummyController {

    @GetMapping
    public String health() {
        return "OK";
    }

}
