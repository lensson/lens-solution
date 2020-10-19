package com.lens.platform.admin.vo;

import lombok.Data;

import java.util.List;

@Data
public class UserVO {

    private Integer id;

    private String nickname;

    private String avatar;

    private List<Integer> roles;

}
