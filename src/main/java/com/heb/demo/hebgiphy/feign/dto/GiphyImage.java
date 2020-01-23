package com.heb.demo.hebgiphy.feign.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GiphyImage {
    private Integer height;
    private String size;
    private String url;
    private Integer width;
}
