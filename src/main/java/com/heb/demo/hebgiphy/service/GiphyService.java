package com.heb.demo.hebgiphy.service;

import com.heb.demo.hebgiphy.feign.GiphyProxy;
import com.heb.demo.hebgiphy.feign.dto.GiphyResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiphyService {
    @Value("${giphy.api_key}")
    private String api_key;

    @Value("${giphy.rating}")
    private String rating;

    @Value("${giphy.lang}")
    private String lang;

    private final GiphyProxy giphyProxy;

    public GiphyService(final GiphyProxy giphyProxy){
        this.giphyProxy = giphyProxy;
    }

    /**
     * @param searchField Search field to query
     * @param limit total number of results. Defaults to 25
     * @param offset starting position of results
     * @return responds with giphy response dto
     */
    public GiphyResponseDto search(String searchField, Integer limit, Integer offset) {
        return giphyProxy.search(api_key, searchField ,limit,offset, rating, lang);
    }

    public GiphyResponseDto getGiphysById(List<String> giphyIds) {
        return giphyProxy.getGiphsByIds(api_key, String.join(",", giphyIds));
    }
}
