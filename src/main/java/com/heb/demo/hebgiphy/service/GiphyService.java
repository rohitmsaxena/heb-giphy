package com.heb.demo.hebgiphy.service;

import com.heb.demo.hebgiphy.feign.GiphyProxy;
import com.heb.demo.hebgiphy.feign.dto.GiphyResponseDto;
import org.springframework.stereotype.Service;

@Service
public class GiphyService {
    private String api_key;

    private final GiphyProxy giphyProxy;

    public GiphyService(final GiphyProxy giphyProxy){
        this.giphyProxy = giphyProxy;
        this.api_key = "A4uBWLId3SYQef1KJ0F6c6oFBmBB41tW";
    }

    public GiphyResponseDto search() {
        return giphyProxy.search(api_key, "test" ,20,
                0, "G", "en");
    }
}
