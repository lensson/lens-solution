package com.lens.blog.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lens.blog.base.entity.SuperEntity;
import lombok.Data;

/**
 * <p>
 * 专题Item表
 * </p>
 *
 * @author Lens
 * @since 2020年8月22日21:56:18
 */
@Data
@TableName("t_subject_item")
public class SubjectItem extends SuperEntity<SubjectItem> {

    private static final long serialVersionUID = 1L;

    /**
     * 专题UID
     */
    private String subjectUid;
    /**
     * 博客uid
     */
    private String blogUid;

    /**
     * 排序字段，数值越大，越靠前
     */
    private int sort;

    /**
     * 博客
     */
    @TableField(exist = false)
    private Blog blog;

}
