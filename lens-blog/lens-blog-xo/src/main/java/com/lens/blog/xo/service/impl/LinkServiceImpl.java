package com.lens.blog.xo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lens.blog.common.entity.Link;
import com.lens.blog.common.feign.PictureFeignClient;
import com.lens.blog.utils.ResultUtil;
import com.lens.blog.utils.StringUtils;
import com.lens.blog.xo.global.MessageConf;
import com.lens.blog.xo.global.SQLConf;
import com.lens.blog.xo.global.SysConf;
import com.lens.blog.xo.mapper.LinkMapper;
import com.lens.blog.xo.service.LinkService;
import com.lens.blog.xo.utils.WebUtil;
import com.lens.blog.xo.vo.LinkVO;
import com.lens.blog.base.enums.ELinkStatus;
import com.lens.blog.base.enums.EStatus;
import com.lens.blog.base.global.BaseSQLConf;
import com.lens.blog.base.global.Constants;
import com.lens.blog.base.serviceImpl.SuperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 友链表 服务实现类
 *
 * @author Lens
 * @since 2018-09-08
 */
@Service
public class LinkServiceImpl extends SuperServiceImpl<LinkMapper, Link> implements LinkService {

    @Resource
    private LinkMapper linkMapper;
    @Autowired
    private LinkService linkService;
    @Resource
    private PictureFeignClient pictureFeignClient;
    @Autowired
    private WebUtil webUtil;

    @Override
    public List<Link> getListByPageSize(Integer pageSize) {
        QueryWrapper<Link> queryWrapper = new QueryWrapper<>();
        Page<Link> page = new Page<>();
        page.setCurrent(1);
        page.setSize(pageSize);
        queryWrapper.eq(BaseSQLConf.LINK_STATUS, ELinkStatus.PUBLISH);
        queryWrapper.eq(BaseSQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.orderByDesc(BaseSQLConf.SORT);
        IPage<Link> pageList = linkMapper.selectPage(page, queryWrapper);
        return pageList.getRecords();
    }

    @Override
    public IPage<Link> getPageList(LinkVO linkVO) {
        QueryWrapper<Link> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(linkVO.getKeyword()) && !StringUtils.isEmpty(linkVO.getKeyword().trim())) {
            queryWrapper.like(SQLConf.TITLE, linkVO.getKeyword().trim());
        }
        if (linkVO.getLinkStatus() != null) {
            queryWrapper.eq(SQLConf.LINK_STATUS, linkVO.getLinkStatus());
        }
        Page<Link> page = new Page<>();
        page.setCurrent(linkVO.getCurrentPage());
        page.setSize(linkVO.getPageSize());
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.orderByDesc(SQLConf.SORT);
        IPage<Link> pageList = linkService.page(page, queryWrapper);
        List<Link> linkList = pageList.getRecords();
        final StringBuffer fileUids = new StringBuffer();
        // 给友情链接添加图片
        linkList.forEach(item -> {
            if (StringUtils.isNotEmpty(item.getFileUid())) {
                fileUids.append(item.getFileUid() + SysConf.FILE_SEGMENTATION);
            }
        });
        String pictureList = null;
        Map<String, String> pictureMap = new HashMap<>();
        if (fileUids != null) {
            pictureList = pictureFeignClient.getPicture(fileUids.toString(), SysConf.FILE_SEGMENTATION);
        }
        List<Map<String, Object>> picList = webUtil.getPictureMap(pictureList);
        picList.forEach(item -> {
            pictureMap.put(item.get(SysConf.UID).toString(), item.get(SysConf.URL).toString());
        });
        for (Link item : linkList) {
            //获取图片
            if (StringUtils.isNotEmpty(item.getFileUid())) {
                List<String> pictureUidsTemp = StringUtils.changeStringToString(item.getFileUid(), Constants.SYMBOL_COMMA);
                List<String> pictureListTemp = new ArrayList<>();

                pictureUidsTemp.forEach(picture -> {
                    pictureListTemp.add(pictureMap.get(picture));
                });
                item.setPhotoList(pictureListTemp);
            }
        }
        pageList.setRecords(linkList);
        return pageList;
    }

    @Override
    public String addLink(LinkVO linkVO) {
        Link link = new Link();
        link.setTitle(linkVO.getTitle());
        link.setSummary(linkVO.getSummary());
        link.setUrl(linkVO.getUrl());
        link.setClickCount(0);
        link.setLinkStatus(linkVO.getLinkStatus());
        link.setSort(linkVO.getSort());
        link.setEmail(linkVO.getEmail());
        link.setFileUid(linkVO.getFileUid());
        link.setStatus(EStatus.ENABLE);
        link.setUpdateTime(new Date());
        link.insert();
        return ResultUtil.successWithMessage(MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String editLink(LinkVO linkVO) {
        Link link = linkService.getById(linkVO.getUid());
        link.setTitle(linkVO.getTitle());
        link.setSummary(linkVO.getSummary());
        link.setLinkStatus(linkVO.getLinkStatus());
        link.setUrl(linkVO.getUrl());
        link.setSort(linkVO.getSort());
        link.setEmail(linkVO.getEmail());
        link.setFileUid(linkVO.getFileUid());
        link.setUpdateTime(new Date());
        link.updateById();
        return ResultUtil.successWithMessage(MessageConf.UPDATE_SUCCESS);
    }

    @Override
    public String deleteLink(LinkVO linkVO) {
        Link link = linkService.getById(linkVO.getUid());
        link.setStatus(EStatus.DISABLED);
        link.setUpdateTime(new Date());
        link.updateById();
        return ResultUtil.successWithMessage(MessageConf.DELETE_SUCCESS);
    }

    @Override
    public String stickLink(LinkVO linkVO) {
        Link link = linkService.getById(linkVO.getUid());
        //查找出最大的那一个
        QueryWrapper<Link> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc(SQLConf.SORT);
        Page<Link> page = new Page<>();
        page.setCurrent(0);
        page.setSize(1);
        IPage<Link> pageList = linkService.page(page, queryWrapper);
        List<Link> list = pageList.getRecords();
        Link maxSort = list.get(0);
        if (StringUtils.isEmpty(maxSort.getUid())) {
            return ResultUtil.errorWithMessage(MessageConf.PARAM_INCORRECT);
        }
        if (maxSort.getUid().equals(link.getUid())) {
            return ResultUtil.errorWithMessage(MessageConf.OPERATION_FAIL);
        }
        Integer sortCount = maxSort.getSort() + 1;
        link.setSort(sortCount);
        link.setUpdateTime(new Date());
        link.updateById();
        return ResultUtil.successWithMessage(MessageConf.OPERATION_SUCCESS);
    }

    @Override
    public String addLinkCount(String uid) {
        if (StringUtils.isEmpty(uid)) {
            return ResultUtil.errorWithMessage(MessageConf.PARAM_INCORRECT);
        }
        Link link = linkService.getById(uid);
        if (link != null) {
            int count = link.getClickCount() + 1;
            link.setClickCount(count);
            link.updateById();
        } else {
            return ResultUtil.errorWithMessage(MessageConf.PARAM_INCORRECT);
        }
        return ResultUtil.successWithMessage(MessageConf.UPDATE_SUCCESS);
    }
}
