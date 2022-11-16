package com.sagaesa.user.dto;

import lombok.Getter;

@Getter
public class PostSignupReq {

    private String name;
    private String password;
    private String nickname;
    private Long categoryId;

}
