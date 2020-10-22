package com.lens.platform.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lens.common.core.entity.BaseEntity;
import lombok.Data;


@Data
public class SysUser extends BaseEntity {

    @TableId
    private Long id;

    private String username;

    private String nickname;

    private String mobile;

    private Integer gender;

    private String avatar;

    private String password;

    private Integer status;

    private Integer deptId;

    private Integer deleted;

    @TableField(exist = false)
    private String deptName;

}
