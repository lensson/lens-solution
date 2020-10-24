package com.lens.auth.service.impl;


import com.lens.auth.domain.User;
import com.lens.common.core.constant.AuthConstants;
import com.lens.common.core.result.Result;
import com.lens.common.core.result.ResultCode;
import com.lens.platform.admin.api.RemoteAdminService;
import com.lens.platform.admin.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc:
 *    自定义用户认证和授权
 * @author Lens Chen
 * @created 2020-10-20 2:32 PM
 */
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private HttpServletRequest request;

//    private RemoteAdminService remoteAdminService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = null;
        String clientId = request.getParameter("client_id");
//        Result<UserDTO> userResult = remoteAdminService.loadUserByUsername(s);
//        if (userResult == null || !ResultCode.SUCCESS.getCode().equals(userResult.getCode())) {
//            throw new UsernameNotFoundException("用户不存在");
//        }
//        UserDTO userDTO = userResult.getData();
//        userDTO.setClientId(clientId);
//        user = new User(userDTO);
        user = forkUser();
        user.setClientId(clientId);

        if (!user.isEnabled()) {
            throw new DisabledException("该账户已被禁用!");
        } else if (!user.isAccountNonLocked()) {
            throw new LockedException("该账号已被锁定!");
        } else if (!user.isAccountNonExpired()) {
            throw new AccountExpiredException("该账号已过期!");
        } else if (!user.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException("该账户的登录凭证已过期，请重新登录!");
        }
        return user;
    }


    private User forkUser() {
        User user = new User();
        user.setClientId(AuthConstants.ADMIN_CLIENT_ID);
        user.setId(Long.parseLong("1"));
        user.setUsername("admin");
        user.setPassword("admin");
        return user;
    }



}
