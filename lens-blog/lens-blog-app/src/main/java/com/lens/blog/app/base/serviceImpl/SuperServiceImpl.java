package com.lens.blog.app.base.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lens.blog.app.base.mapper.SuperMapper;
import com.lens.blog.app.base.service.SuperService;

/**
 * @author Lens Chen
 * @created 2020-11-11 9:33 AM
 * @Description
 */
public class SuperServiceImpl<M extends SuperMapper<T>, T> extends ServiceImpl<M, T> implements SuperService<T> {

}
