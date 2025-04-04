package com.lens.blog.picture.vo;

import com.lens.blog.base.validator.annotion.NotBlank;
import com.lens.blog.base.validator.group.Insert;
import com.lens.blog.base.vo.BaseVO;
import lombok.Data;

/**
 * CommentVO
 *
 * @author: Lens
 * @create: 2020年1月11日16:15:52
 */
@Data
public class NetworkDiskVO extends BaseVO<NetworkDiskVO> {

    /**
     * 管理员UID
     */
    @NotBlank(groups = {Insert.class})
    private String adminUid;

    /**
     * 文件URL
     */
    private String fileUrl;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 旧文件名
     */
    private String fileOldName;

    /**
     * 时间戳名称
     */
    private String timestampName;

    /**
     * 扩展名
     */
    private String extendName;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件大小
     */
    private long fileSize;

    /**
     * 是否是目录
     */
    private int isDir;

    /**
     * 旧文件路径
     */
    private String oldFilePath;

    /**
     * 新文件路径
     */
    private String newFilePath;

    /**
     * 文件列表
     */
    private String files;

    /**
     * 文件类型
     */
    private int fileType;
}
