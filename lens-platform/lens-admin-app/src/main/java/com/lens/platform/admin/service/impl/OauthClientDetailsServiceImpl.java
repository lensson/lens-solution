package com.lens.platform.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lens.platform.admin.entity.OauthClientDetails;
import com.lens.platform.admin.mapper.OauthClientDetailsMapper;
import com.lens.platform.admin.service.IOauthClientDetailsService;
import org.springframework.stereotype.Service;

@Service
public class OauthClientDetailsServiceImpl extends ServiceImpl<OauthClientDetailsMapper, OauthClientDetails> implements IOauthClientDetailsService {
}
