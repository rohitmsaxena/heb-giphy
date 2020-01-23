package com.heb.demo.hebgiphy.controller;

import com.heb.demo.hebgiphy.feign.GiphyProxy;
import com.heb.demo.hebgiphy.feign.dto.GiphyResponseDto;
import com.heb.demo.hebgiphy.model.Greeting;
import com.heb.demo.hebgiphy.service.GiphyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final GiphyService giphyService;

    @Autowired
    public GreetingController(final GiphyService giphyService) {
        this.giphyService = giphyService;
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/giphytest")
    public GiphyResponseDto giphyTest() {
        return giphyService.search();
    }
}
