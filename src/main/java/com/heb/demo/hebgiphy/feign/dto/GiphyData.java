package com.heb.demo.hebgiphy.feign.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class GiphyData {
    private String type;
    private String id;
    private String url;
    private String embed_url;
    private String title;
    private String rating;
    private GiphyImages images;
}
