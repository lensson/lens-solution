package com.lens.platform.admin.api;

import com.lens.common.core.result.Result;
import com.lens.platform.admin.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Desc:
 *
 * @author Lens Chen
 * @created 2020-10-19 12:37 PM
 */
@FeignClient("lens-admin-app")
public interface RemoteAdminService {

    @GetMapping("/users/user/{username}")
    Result<UserDTO> loadUserByUsername(@PathVariable String username);
}

