package com.lens.blog.xo.mapper;


import com.lens.blog.common.entity.Todo;
import com.lens.blog.base.enums.EStatus;
import com.lens.blog.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 待办事项表 Mapper 接口
 *
 * @author Lens
 * @since 2019年6月29日10:30:37
 */
public interface TodoMapper extends SuperMapper<Todo> {

    /**
     * 批量更新未删除的代表事项的状态
     *
     * @param done
     */
    @Select("UPDATE t_todo SET done = #{done} WHERE STATUS = " + EStatus.ENABLE + " AND admin_uid = #{adminUid}")
    public void toggleAll(@Param("done") Integer done, @Param("adminUid") String adminUid);
}
