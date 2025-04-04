package com.lens.blog.xo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lens.blog.common.entity.SystemConfig;
import com.lens.blog.utils.RedisUtil;
import com.lens.blog.utils.ResultUtil;
import com.lens.blog.utils.StringUtils;
import com.lens.blog.xo.global.MessageConf;
import com.lens.blog.xo.global.RedisConf;
import com.lens.blog.xo.global.SQLConf;
import com.lens.blog.xo.global.SysConf;
import com.lens.blog.xo.mapper.SystemConfigMapper;
import com.lens.blog.xo.service.BlogService;
import com.lens.blog.xo.service.SystemConfigService;
import com.lens.blog.xo.vo.SystemConfigVO;
import com.lens.blog.base.enums.EOpenStatus;
import com.lens.blog.base.enums.EStatus;
import com.lens.blog.base.global.Constants;
import com.lens.blog.base.serviceImpl.SuperServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


/**
 * 系统配置关系表 服务实现类
 *
 * @author Lens
 * @date 2020年1月21日09:06:18
 */
@Slf4j
@Service
public class SystemConfigServiceImpl extends SuperServiceImpl<SystemConfigMapper, SystemConfig> implements SystemConfigService {

    @Autowired
    private SystemConfigService systemConfigService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public SystemConfig getConfig() {
        QueryWrapper<SystemConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc(SQLConf.CREATE_TIME);
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.last(SysConf.LIMIT_ONE);
        SystemConfig SystemConfig = systemConfigService.getOne(queryWrapper);
        return SystemConfig;
    }

    @Override
    public String cleanRedisByKey(List<String> key) {
        if (key == null) {
            return ResultUtil.result(SysConf.ERROR, MessageConf.OPERATION_FAIL);
        }
        key.forEach(item -> {
            // 表示清空所有key
            if (RedisConf.ALL.equals(item)) {
                Set<String> keys = redisUtil.keys(Constants.SYMBOL_STAR);
                redisUtil.delete(keys);
            } else {
                // 获取Redis中特定前缀
                Set<String> keys = redisUtil.keys(key + Constants.SYMBOL_STAR);
                redisUtil.delete(keys);
            }
        });
        return ResultUtil.successWithMessage(MessageConf.OPERATION_SUCCESS);
    }

    @Override
    public String editSystemConfig(SystemConfigVO systemConfigVO) {
        // 图片必须选择上传到一个区域
        if (EOpenStatus.CLOSE.equals(systemConfigVO.getUploadLocal()) && EOpenStatus.CLOSE.equals(systemConfigVO.getUploadQiNiu())) {
            return ResultUtil.errorWithMessage(MessageConf.PICTURE_MUST_BE_SELECT_AREA);
        }
        // 图片显示优先级为本地优先，必须开启图片上传本地
        if (EOpenStatus.CLOSE.equals(systemConfigVO.getPicturePriority()) && EOpenStatus.CLOSE.equals(systemConfigVO.getUploadLocal())) {
            return ResultUtil.errorWithMessage(MessageConf.MUST_BE_OPEN_LOCAL_UPLOAD);
        }
        // 图片显示优先级为七牛云优先，必须开启图片上传七牛云
        if (EOpenStatus.OPEN.equals(systemConfigVO.getPicturePriority()) && EOpenStatus.CLOSE.equals(systemConfigVO.getUploadQiNiu())) {
            return ResultUtil.errorWithMessage(MessageConf.MUST_BE_OPEN_QI_NIU_UPLOAD);
        }
        // 开启Email邮件通知时，必须保证Email字段不为空
        if (EOpenStatus.OPEN.equals(systemConfigVO.getStartEmailNotification()) && StringUtils.isEmpty(systemConfigVO.getEmail())) {
            return ResultUtil.errorWithMessage(MessageConf.MUST_BE_SET_EMAIL);
        }
        if (StringUtils.isEmpty(systemConfigVO.getUid())) {
            SystemConfig systemConfig = new SystemConfig();
            // 设置七牛云、邮箱、系统配置相关属性【使用Spring工具类提供的深拷贝】
            BeanUtils.copyProperties(systemConfigVO, systemConfig, SysConf.STATUS);
            systemConfig.insert();
        } else {
            SystemConfig systemConfig = systemConfigService.getById(systemConfigVO.getUid());

            // 判断是否更新了图片显示优先级【如果更新了，需要请求Redis中的博客，否者将导致图片无法正常显示】
            if(systemConfigVO.getPicturePriority() != systemConfig.getPicturePriority()) {
                blogService.deleteRedisByBlog();
            }

            // 设置七牛云、邮箱、系统配置相关属性【使用Spring工具类提供的深拷贝】
            BeanUtils.copyProperties(systemConfigVO, systemConfig, SysConf.STATUS, SysConf.UID);
            systemConfig.updateById();

        }
        // 更新系统配置成功后，需要删除Redis中的系统配置
        redisUtil.delete(RedisConf.SYSTEM_CONFIG);
        return ResultUtil.successWithMessage(MessageConf.UPDATE_SUCCESS);
    }
}
