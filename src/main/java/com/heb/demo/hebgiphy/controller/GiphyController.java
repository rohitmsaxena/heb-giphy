package com.heb.demo.hebgiphy.controller;

import com.heb.demo.hebgiphy.feign.dto.GiphyResponseDto;
import com.heb.demo.hebgiphy.service.AuthenticationService;
import com.heb.demo.hebgiphy.service.GiphyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/giphy")
@Slf4j
public class GiphyController {
    private final GiphyService giphyService;
    private final AuthenticationService authenticationService;

    @Autowired
    public GiphyController(final GiphyService giphyService, final AuthenticationService authenticationService){
        this.giphyService = giphyService;
        this.authenticationService = authenticationService;
    }

    @GetMapping(value = "/search")
    public GiphyResponseDto search(@RequestParam String idToken,
                                   @RequestParam String query,
                                   @RequestParam(required = false, defaultValue = "20") Integer limit,
                                   @RequestParam(required = false, defaultValue = "0") Integer offset) {
        return giphyService.search(query, limit, offset);
    }

    /**
     * @param idToken verification token
     * @param giphyId the giphy id to save to the db
     * @return true if can ve saved, false if the user isn't logged in.
     */
    @GetMapping(value = "/save")
    public boolean save(@RequestParam String idToken,
                        @RequestParam String giphyId) {
        System.out.println(giphyId);
        return this.authenticationService.save(idToken, giphyId);
    }

    /**
     * @param idToken verification token
     * @param giphyId the giphy id to save to the db
     * @return true if can be saved, false if the user isn't logged in.
     */
    @GetMapping(value="/remove")
    public boolean remove(@RequestParam String idToken,
                        @RequestParam String giphyId) {
        return this.authenticationService.remove(idToken, giphyId);
    }

    @GetMapping(value="/getAll")
    public GiphyResponseDto getAll(@RequestParam String idToken) {
        List<String> listOfGiphIds = this.authenticationService.getAll(idToken);
        return giphyService.getGiphysById(listOfGiphIds);

    }
}
