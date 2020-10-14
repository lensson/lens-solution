package com.lens.platform.security.entity;

import com.lens.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 平台用户
 * </p>
 *
 * @author Lens Chen
 * @since 2020-10-14
 */
@Data
  @EqualsAndHashCode(callSuper = true)
  @Accessors(chain = true)
@ApiModel(value="User对象", description="平台用户")
public class User extends BaseEntity {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "创建者")
      private String createId;

      @ApiModelProperty(value = "更新者")
      private String updateId;

      @ApiModelProperty(value = "更新时间")
      private Date updateTime;

      @ApiModelProperty(value = "用户备注")
      private String remark;


}
