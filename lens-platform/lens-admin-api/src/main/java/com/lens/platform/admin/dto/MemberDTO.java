package com.lens.platform.admin.dto;

import lombok.Data;

@Data
public class MemberDTO {

    private Long id;
    private String username;
    private String password;
    private Integer status;
    private String clientId;

    private String avatar;
    private String nickname;

}
