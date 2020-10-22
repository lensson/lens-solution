package com.lens.platform.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lens.common.core.entity.BaseEntity;
import lombok.Data;

@Data
public class SysDict  extends BaseEntity {

    @TableId(type= IdType.AUTO)
    private Integer id;

    private String name;

    private String value;

    private String typeCode;

    private String sort;

    private Integer status;

    private Integer defaulted;

    private String remark;

}
