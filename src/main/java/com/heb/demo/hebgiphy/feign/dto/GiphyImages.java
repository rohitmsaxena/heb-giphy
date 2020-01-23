package com.heb.demo.hebgiphy.feign.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GiphyImages {
    private GiphyImage downsized_large;
//    private GiphyImage fixed_height_small_still;
    private GiphyImage original;
//    private GiphyImage fixed_height_downsampled;
//    private GiphyImage downsized_still;
//    private GiphyImage fixed_height_still;
//    private GiphyImage downsized_medium;
//    private GiphyImage downsized;
//    private GiphyImage preview_webp;
    private GiphyVideo original_mp4;
//    private GiphyVideo fixed_height_small;
//    private GiphyVideo fixed_height;

}
