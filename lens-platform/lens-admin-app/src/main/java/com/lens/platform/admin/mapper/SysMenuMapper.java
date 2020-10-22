package com.lens.platform.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lens.platform.admin.entity.SysMenu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    @Select("<script>" +
            "   select id ,name ,parent_id,path,component,perms,icon,sort,visible,status from sys_menu " +
            "   where status=1 and type in (0,1)" +
            "   order by sort asc" +
            "</script>")
    @Results({
            @Result(id=true, column="id", property="id"),
            // 一对多关联查询拥有菜单访问权限的角色ID集合
            @Result(property = "roles",column="id",many = @Many(select="com.youlai.admin.mapper.SysRoleMenuMapper.listByMenuId"))
    })
    List<SysMenu> listForRouter();
}
