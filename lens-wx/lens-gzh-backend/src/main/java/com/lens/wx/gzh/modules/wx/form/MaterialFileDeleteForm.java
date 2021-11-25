package com.lens.wx.gzh.modules.wx.form;

import com.lens.wx.gzh.common.utils.Json;
import lombok.Data;

@Data
public class MaterialFileDeleteForm {
    String mediaId;

    @Override
    public String toString() {
        return Json.toJsonString(this);
    }
}
