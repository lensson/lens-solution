package com.lens.wx.gzh.security.entity;

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
 * 微信用户
 * </p>
 *
 * @author Lens Chen
 * @since 2020-10-14
 */
@Data
  @EqualsAndHashCode(callSuper = true)
    @TableName("wx_user")
@ApiModel(value="User对象", description="微信用户")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "创建者")
      private String createId;

      @ApiModelProperty(value = "更新者")
      private String updateId;

      @ApiModelProperty(value = "更新时间")
      private Date updateTime;

      @ApiModelProperty(value = "用户备注")
      private String remark;

      @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
      private String delFlag;

      @ApiModelProperty(value = "应用类型(1:小程序，2:公众号)")
      private String appType;

      @ApiModelProperty(value = "是否订阅（1：是；0：否；2：网页授权用户）")
      private String subscribe;

      @ApiModelProperty(value = "返回用户关注的渠道来源，ADD_SCENE_SEARCH 公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，ADD_SCENE_PROFILE_CARD 名片分享，ADD_SCENE_QR_CODE 扫描二维码，ADD_SCENEPROFILE LINK 图文页内名称点击，ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_OTHERS 其他")
      private String subscribeScene;

      @ApiModelProperty(value = "关注时间")
      private Date subscribeTime;

      @ApiModelProperty(value = "关注次数")
      private Integer subscribeNum;

      @ApiModelProperty(value = "取消关注时间")
      private Date cancelSubscribeTime;

      @ApiModelProperty(value = "用户标识")
      private String openId;

      @ApiModelProperty(value = "昵称")
      private String nickName;

      @ApiModelProperty(value = "性别（1：男，2：女，0：未知）")
      private String sex;

      @ApiModelProperty(value = "所在城市")
      private String city;

      @ApiModelProperty(value = "所在国家")
      private String country;

      @ApiModelProperty(value = "所在省份")
      private String province;

      @ApiModelProperty(value = "手机号码")
      private String phone;

      @ApiModelProperty(value = "用户语言")
      private String language;

      @ApiModelProperty(value = "头像")
      private String headimgUrl;

      @ApiModelProperty(value = "union_id")
      private String unionId;

      @ApiModelProperty(value = "用户组")
      private String groupId;

      @ApiModelProperty(value = "标签列表")
      private String tagidList;

      @ApiModelProperty(value = "二维码扫码场景")
      private String qrSceneStr;

      @ApiModelProperty(value = "地理位置纬度")
      private Double latitude;

      @ApiModelProperty(value = "地理位置经度")
      private Double longitude;

      @ApiModelProperty(value = "地理位置精度")
      private Double precision;

      @ApiModelProperty(value = "会话密钥")
      private String sessionKey;

      @ApiModelProperty(value = "商城用户ID")
      private String mallUserId;


}
