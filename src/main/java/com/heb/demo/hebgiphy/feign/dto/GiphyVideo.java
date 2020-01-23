package com.heb.demo.hebgiphy.feign.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GiphyVideo {
    private Integer height;
    private String mp4;
    private Integer mp4_size;
    private Integer width;
}
