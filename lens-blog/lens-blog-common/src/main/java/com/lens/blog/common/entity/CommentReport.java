package com.lens.blog.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lens.blog.base.entity.SuperEntity;
import lombok.Data;

/**
 * <p>
 * 评论举报表
 * </p>
 *
 * @author Lens
 * @since 2020年1月12日15:42:19
 */
@Data
@TableName("t_comment_report")
public class CommentReport extends SuperEntity<CommentReport> {

    private static final long serialVersionUID = 1L;

    /**
     * 举报人UID
     */
    private String userUid;

    /**
     * 被举报的评论Uid
     */
    private String reportCommentUid;

    /**
     * 被举报的用户uid
     */
    private String reportUserUid;


    /**
     * 举报原因
     */
    private String content;

    /**
     * 进展状态: 0 未查看   1: 已查看  2：已处理
     */
    private Integer progress;

}
