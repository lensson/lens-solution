package com.lens.wx.gzh.autoreply.entity;

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
 * 微信自动回复
 * </p>
 *
 * @author Lens Chen
 * @since 2020-10-14
 */
@Data
  @EqualsAndHashCode(callSuper = true)
    @TableName("wx_auto_reply")
@ApiModel(value="AutoReply对象", description="微信自动回复")
public class AutoReply extends BaseEntity {

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

      @ApiModelProperty(value = "类型（1、关注时回复；2、消息回复；3、关键词回复）")
      private String type;

      @ApiModelProperty(value = "关键词")
      private String reqKey;

      @ApiModelProperty(value = "请求消息类型（text：文本；image：图片；voice：语音；video：视频；shortvideo：小视频；location：地理位置）")
      private String reqType;

      @ApiModelProperty(value = "回复消息类型（text：文本；image：图片；voice：语音；video：视频；music：音乐；news：图文）")
      private String repType;

      @ApiModelProperty(value = "回复类型文本匹配类型（1、全匹配，2、半匹配）")
      private String repMate;

      @ApiModelProperty(value = "回复类型文本保存文字")
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

      @ApiModelProperty(value = "缩略图的媒体id")
      private String repThumbMediaId;

      @ApiModelProperty(value = "缩略图url")
      private String repThumbUrl;

      @ApiModelProperty(value = "图文消息的内容")
      private String content;


}
