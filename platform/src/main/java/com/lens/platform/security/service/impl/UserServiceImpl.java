package com.lens.platform.security.service.impl;

import com.lens.platform.security.entity.User;
import com.lens.platform.security.mapper.UserMapper;
import com.lens.platform.security.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 平台用户 服务实现类
 * </p>
 *
 * @author Lens Chen
 * @since 2020-10-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
