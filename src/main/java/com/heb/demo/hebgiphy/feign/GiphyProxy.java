package com.heb.demo.hebgiphy.feign;

import com.heb.demo.hebgiphy.feign.dto.GiphyResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "GiphyClient", url = "https://api.giphy.com/v1/gifs")
public interface GiphyProxy {
    @GetMapping(value = "search")
    GiphyResponseDto search(@RequestParam("api_key") String apiKey,
                            @RequestParam("q") String search,
                            @RequestParam("limit") Integer limit,
                            @RequestParam("offset") Integer offset,
                            @RequestParam("rating") String rating,
                            @RequestParam("lang") String lang);
}
