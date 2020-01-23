package com.heb.demo.hebgiphy.feign.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GiphyPagination {
    private Integer total_count;
    private Integer count;
    private Integer offset;
}
