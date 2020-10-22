package com.lens.platform.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lens.common.core.constant.AuthConstants;
import com.lens.common.core.result.PageResult;
import com.lens.common.core.result.Result;
import com.lens.platform.admin.dto.UserDTO;
import com.lens.platform.admin.entity.SysUser;
import com.lens.platform.admin.entity.SysUserRole;
import com.lens.platform.admin.service.ISysRoleService;
import com.lens.platform.admin.service.ISysUserRoleService;
import com.lens.platform.admin.service.ISysUserService;
import com.lens.platform.admin.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "用户接口")
@RestController
@RequestMapping("/users")
@Slf4j
@AllArgsConstructor
public class SysUserController {

    private final ISysUserService iSysUserService;
    private final ISysUserRoleService iSysUserRoleService;
    private final ISysRoleService iSysRoleService;
    private final PasswordEncoder passwordEncoder;

    @ApiOperation(value = "列表分页", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "user", value = "用户信息", paramType = "query", dataType = "SysUser")
    })
    @GetMapping
    public Result list(Integer page, Integer limit, SysUser user) {
        IPage<SysUser> result = iSysUserService.list(new Page<>(page, limit), user);
        return PageResult.success(result.getRecords(), result.getTotal());
    }

    @ApiOperation(value = "用户详情", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "Integer")
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        SysUser user = iSysUserService.getById(id);
        return Result.success(user);
    }


    @ApiOperation(value = "新增用户", httpMethod = "POST")
    @ApiImplicitParam(name = "user", value = "实体JSON对象", required = true, paramType = "body", dataType = "SysUser")
    @PostMapping
    public Result add(@RequestBody SysUser user) {
        boolean status = iSysUserService.save(user);
        return Result.status(status);
    }

    @ApiOperation(value = "修改用户", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "Integer"),
            @ApiImplicitParam(name = "user", value = "实体JSON对象", required = true, paramType = "body", dataType = "SysUser")
    })
    @PutMapping(value = "/{id}")
    public Result update(
            @PathVariable Integer id,
            @RequestBody SysUser user) {
        user.setUpdateTime(new Date());
        boolean status = iSysUserService.updateById(user);
        return Result.status(status);
    }

    @ApiOperation(value = "删除用户", httpMethod = "DELETE")
    @ApiImplicitParam(name = "ids[]", value = "id集合", required = true, paramType = "query", allowMultiple = true, dataType = "Integer")
    @DeleteMapping
    public Result delete(@RequestParam("ids") List<Long> ids) {
        boolean status = iSysUserService.removeByIds(ids);
        return Result.status(status);
    }

    @ApiOperation(value = "用户名获取用户信息", httpMethod = "GET")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "path", dataType = "String")
    @GetMapping("/user/{username}")
    public Result<UserDTO> loadUserByUsername(@PathVariable String username) {
        UserDTO userDTO = null;
        SysUser user = iSysUserService.getOne(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUsername, username));
        if (user != null) {
            userDTO = new UserDTO();
            BeanUtil.copyProperties(user, userDTO);
            List<Integer> roleIds = iSysUserRoleService.list(new LambdaQueryWrapper<SysUserRole>()
                    .eq(SysUserRole::getUserId, user.getId())
            ).stream().map(item -> item.getRoleId()).collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(roleIds)) {
                List<Integer> roles = iSysRoleService.listByIds(roleIds).stream()
                        .map(role -> role.getId()).collect(Collectors.toList());
                userDTO.setRoles(roles);
            }
        }
        return Result.success(userDTO);
    }


    @ApiOperation(value = "获取当前请求的用户信息", httpMethod = "GET")
    @GetMapping("/me")
    public Result getCurrentUserInfo(HttpServletRequest request) {
        String payload = request.getHeader(AuthConstants.JWT_PAYLOAD_KEY);
        JSONObject jsonObject = JSONUtil.parseObj(payload);
        Long id = jsonObject.getLong("id");
        SysUser user = iSysUserService.getById(id);
        UserVO userVO = new UserVO();
        BeanUtil.copyProperties(user, userVO);
        List<Integer> roleIds = iSysUserRoleService.list(new LambdaQueryWrapper<SysUserRole>()
                .eq(SysUserRole::getUserId, user.getId())
        ).stream().map(item -> item.getRoleId()).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(roleIds)) {
            List<Integer> roles = iSysRoleService.listByIds(roleIds)
                    .stream()
                    .map(role -> role.getId())
                    .collect(Collectors.toList());
            userVO.setRoles(roles);
        }
        return Result.success(userVO);
    }

    @ApiOperation(value = "修改用户", httpMethod = "PATCH")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "Integer"),
            @ApiImplicitParam(name = "user", value = "实体JSON对象", required = true, paramType = "body", dataType = "SysUser")
    })
    @PatchMapping(value = "/{id}")
    public Result patch(@PathVariable Integer id, @RequestBody SysUser user) {
        LambdaUpdateWrapper<SysUser> luw = new LambdaUpdateWrapper<SysUser>().eq(SysUser::getId, id);
        if (user.getStatus() != null) { // 状态更新
            luw.set(SysUser::getStatus, user.getStatus());
        } else if (user.getPassword() != null) { // 密码重置
            String password = passwordEncoder.encode(user.getPassword());
            luw.set(SysUser::getPassword, password);
        } else {
            return Result.success();
        }
        boolean update = iSysUserService.update(luw);
        return Result.success(update);
    }

}
