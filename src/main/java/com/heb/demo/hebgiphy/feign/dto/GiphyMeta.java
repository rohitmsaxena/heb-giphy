package com.heb.demo.hebgiphy.feign.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GiphyMeta {
    private Integer status;
    private String msg;
    private String response_id;
}
