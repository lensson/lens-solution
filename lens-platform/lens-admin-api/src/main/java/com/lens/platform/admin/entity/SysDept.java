package com.lens.platform.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lens.common.core.entity.BaseEntity;
import lombok.Data;

@Data
public class SysDept extends BaseEntity {

    @TableId(type= IdType.AUTO)
    private Integer id;

    private String name;

    private Integer parentId;

    private String treePath;

    private Integer sort;

    private Integer status;

    private Integer deleted;

    private String leader;

    private String mobile;

    private String email;

}
