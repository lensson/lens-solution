package com.lens.blog.xo.service.impl;

import com.lens.blog.common.entity.CommentReport;
import com.lens.blog.xo.mapper.CommentReportMapper;
import com.lens.blog.xo.service.CommentReportService;
import com.lens.blog.base.serviceImpl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论举报表 服务实现类
 * </p>
 *
 * @author Lens
 * @since 2020年1月12日15:47:47
 */
@Service
public class CommentReportServiceImpl extends SuperServiceImpl<CommentReportMapper, CommentReport> implements CommentReportService {

}
