package com.sagaesa.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class GetUserProfileRes {
    private String nickname;
    private Long avatarId;
}
