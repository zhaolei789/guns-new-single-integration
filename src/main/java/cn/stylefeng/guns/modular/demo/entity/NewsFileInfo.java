package cn.stylefeng.guns.modular.demo.entity;

import java.util.Date;

import cn.stylefeng.roses.kernel.db.api.pojo.entity.BaseEntity;
import cn.stylefeng.roses.kernel.rule.annotation.ChineseDescription;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * 文件信息(NewsFileInfo)表实体类
 *
 * @author makejava
 * @since 2022-10-18 17:28:37
 */
@SuppressWarnings("serial")
@Data
@TableName("news_file_info")
public class NewsFileInfo extends BaseEntity {
    @TableId(
            value = "file_id",
            type = IdType.ASSIGN_ID
    )
    @ChineseDescription("主键id")
    private Long fileId;
    @TableField("file_code")
    @ChineseDescription("文件编码")
    private Long fileCode;
    @TableField("file_version")
    @ChineseDescription("文件版本")
    private Integer fileVersion;
    @TableField("file_status")
    @ChineseDescription("当前状态：0-历史版，1-最新版")
    private String fileStatus;
    @TableField("file_location")
    @ChineseDescription("文件存储位置")
    private Integer fileLocation;
    @TableField("file_bucket")
    @ChineseDescription("文件仓库(文件夹)")
    private String fileBucket;
    @TableField("file_origin_name")
    @ChineseDescription("文件名称（上传时候的文件全名）")
    private String fileOriginName;
    @TableField("file_suffix")
    @ChineseDescription("文件后缀")
    private String fileSuffix;
    @TableField("file_size_kb")
    @ChineseDescription("文件大小")
    private Long fileSizeKb;
    @TableField("file_size_info")
    @ChineseDescription("文件大小信息，计算后的")
    private String fileSizeInfo;
    @TableField("file_object_name")
    @ChineseDescription("存储到bucket中的名称，主键id+.后缀")
    private String fileObjectName;
    @TableField("file_path")
    @ChineseDescription("存储路径")
    private String filePath;
    @TableField("secret_flag")
    @ChineseDescription("是否为机密文件")
    private String secretFlag;
    @TableField(
            value = "del_flag",
            fill = FieldFill.INSERT
    )
    @ChineseDescription("是否删除")
    private String delFlag;
}

