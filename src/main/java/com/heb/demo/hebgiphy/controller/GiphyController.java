package com.heb.demo.hebgiphy.controller;

import com.heb.demo.hebgiphy.feign.dto.GiphyResponseDto;
import com.heb.demo.hebgiphy.service.GiphyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/giphy")
@Slf4j
public class GiphyController {
    private final GiphyService giphyService;

    @Autowired
    public GiphyController(final GiphyService giphyService){
        this.giphyService = giphyService;
    }

//    @CrossOrigin
    @GetMapping(value = "/search")
    public GiphyResponseDto search(@RequestParam String query,
                                   @RequestParam(required = false, defaultValue = "20") Integer limit,
                                   @RequestParam(required = false, defaultValue = "0") Integer offset) {
        log.debug("Query {}", query);
        log.debug("Limit {}", limit);
        log.debug("Offset {}", offset);
        return giphyService.search(query, limit, offset);
    }
}
