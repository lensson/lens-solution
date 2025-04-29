package com.lens.platform.api.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder(toBuilder = true)
public class User {
    private Long id;
    private String username;
    private String password;
    private List<String> roles;
}