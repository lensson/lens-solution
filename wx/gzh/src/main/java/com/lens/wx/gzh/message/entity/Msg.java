package com.lens.wx.gzh.message.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lens.common.core.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * <p>
 * 微信消息
 * </p>
 *
 * @author Lens Chen
 * @since 2020-10-14
 */
@Data
  @EqualsAndHashCode(callSuper = true)
    @TableName("wx_msg")
@ApiModel(value="Msg对象", description="微信消息")
public class Msg extends BaseEntity {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "创建者")
      private String createId;

      @ApiModelProperty(value = "更新者")
      private String updateId;

      @ApiModelProperty(value = "更新时间")
      private Date updateTime;

      @ApiModelProperty(value = "备注")
      private String remark;

      @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
      private String delFlag;

      @ApiModelProperty(value = "公众号名称")
      private String appName;

      @ApiModelProperty(value = "公众号logo")
      private String appLogo;

      @ApiModelProperty(value = "微信用户ID")
      private String wxUserId;

      @ApiModelProperty(value = "微信用户昵称")
      private String nickName;

      @ApiModelProperty(value = "微信用户头像")
      private String headimgUrl;

      @ApiModelProperty(value = "消息分类（1、用户发给公众号；2、公众号发给用户；）")
      private String type;

      @ApiModelProperty(value = "消息类型（text：文本；image：图片；voice：语音；video：视频；shortvideo：小视频；location：地理位置；music：音乐；news：图文；event：推送事件）")
      private String repType;

      @ApiModelProperty(value = "事件类型（subscribe：关注；unsubscribe：取关；CLICK、VIEW：菜单事件）")
      private String repEvent;

      @ApiModelProperty(value = "回复类型文本保存文字、地理位置信息")
      private String repContent;

      @ApiModelProperty(value = "回复类型imge、voice、news、video的mediaID或音乐缩略图的媒体id")
      private String repMediaId;

      @ApiModelProperty(value = "回复的素材名、视频和音乐的标题")
      private String repName;

      @ApiModelProperty(value = "视频和音乐的描述")
      private String repDesc;

      @ApiModelProperty(value = "链接")
      private String repUrl;

      @ApiModelProperty(value = "高质量链接")
      private String repHqUrl;

      @ApiModelProperty(value = "图文消息的内容")
      private String content;

      @ApiModelProperty(value = "缩略图的媒体id")
      private String repThumbMediaId;

      @ApiModelProperty(value = "缩略图url")
      private String repThumbUrl;

      @ApiModelProperty(value = "地理位置维度")
      private Double repLocationX;

      @ApiModelProperty(value = "地理位置经度")
      private Double repLocationY;

      @ApiModelProperty(value = "地图缩放大小")
      private Double repScale;

      @ApiModelProperty(value = "已读标记（1：是；0：否）")
      private String readFlag;


}
