package com.lens.platform.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lens.common.core.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class SysResource extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String url;

    // 拥有资源权限角色ID集合
    @TableField(exist = false)
    private List<Integer> roleIds;
}
