package com.lens.wx.gzh.menu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lens.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 自定义菜单表
 * </p>
 *
 * @author Lens Chen
 * @since 2020-10-14
 */
@Data
  @EqualsAndHashCode(callSuper = true)
    @TableName("wx_menu")
@ApiModel(value="Menu对象", description="自定义菜单表")
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
      private String delFlag;

      @ApiModelProperty(value = "更新时间")
      private Date updateTime;

      @ApiModelProperty(value = "排序值")
      private Integer sort;

      @ApiModelProperty(value = "父菜单ID")
      private String parentId;

      @ApiModelProperty(value = "菜单类型click、view、miniprogram、scancode_push、scancode_waitmsg、pic_sysphoto、pic_photo_or_album、pic_weixin、location_select、media_id、view_limited等")
      private String type;

      @ApiModelProperty(value = "菜单名")
      private String name;

      @ApiModelProperty(value = "view、miniprogram保存链接")
      private String url;

      @ApiModelProperty(value = "小程序的appid")
      private String maAppId;

      @ApiModelProperty(value = "小程序的页面路径")
      private String maPagePath;

      @ApiModelProperty(value = "回复消息类型（text：文本；image：图片；voice：语音；video：视频；music：音乐；news：图文）")
      private String repType;

      @ApiModelProperty(value = "Text:保存文字")
      private String repContent;

      @ApiModelProperty(value = "imge、voice、news、video：mediaID")
      private String repMediaId;

      @ApiModelProperty(value = "素材名、视频和音乐的标题")
      private String repName;

      @ApiModelProperty(value = "视频和音乐的描述")
      private String repDesc;

      @ApiModelProperty(value = "链接")
      private String repUrl;

      @ApiModelProperty(value = "高质量链接")
      private String repHqUrl;

      @ApiModelProperty(value = "缩略图的媒体id")
      private String repThumbMediaId;

      @ApiModelProperty(value = "缩略图url")
      private String repThumbUrl;

      @ApiModelProperty(value = "图文消息的内容")
      private String content;


}
