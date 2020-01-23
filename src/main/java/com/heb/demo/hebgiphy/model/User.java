package com.heb.demo.hebgiphy.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String giphyId;
//    List<GiphyObject> giphyObjects;
//    Set<Role> roles;
}
