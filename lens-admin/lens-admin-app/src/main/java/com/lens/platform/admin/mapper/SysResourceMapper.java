package com.lens.platform.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lens.platform.admin.entity.SysResource;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysResourceMapper extends BaseMapper<SysResource> {


    @Select(" select id,name,url from sys_resource ")
    @Results({
            @Result(id=true, column="id", property="id"),
            @Result(property = "roleIds",column="id",many = @Many(select="com.youlai.admin.mapper.SysRoleResourceMapper.listByResourceId"))
    })
    List<SysResource> listForResourceRoles();
}
