package cn.stylefeng.guns.modular.demo.model.in;

import cn.stylefeng.roses.kernel.db.api.pojo.entity.BaseEntity;
import cn.stylefeng.roses.kernel.file.api.pojo.request.SysFileInfoRequest;
import cn.stylefeng.roses.kernel.rule.annotation.ChineseDescription;
import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 文件信息(NewsFileInfo)表实体类
 *
 * @author makejava
 * @since 2022-10-18 17:28:37
 */
@SuppressWarnings("serial")
@Data
public class NewsFileInfoReq extends BaseRequest {
    @ChineseDescription("文件id")
    private @NotNull(
            message = "fileId不能为空",
            groups = {SysFileInfoRequest.versionBack.class, BaseRequest.detail.class}
    ) Long fileId;
    @ChineseDescription("文件编码")
    private @NotNull(
            message = "fileCode不能为空",
            groups = {BaseRequest.edit.class, BaseRequest.delete.class}
    ) Long fileCode;
    @ChineseDescription("是否为机密文件，Y-是机密，N-不是机密")
    private @NotBlank(
            message = "是否是机密文件不能为空",
            groups = {BaseRequest.add.class, BaseRequest.edit.class}
    ) String secretFlag;
    @ChineseDescription("文件名称（上传时候的文件全名，例如：开发文档.txt）")
    private String fileOriginName;
    @ChineseDescription("其他文件形式参数")
    private String token;
    @ChineseDescription("文件存储位置：1-阿里云，2-腾讯云，3-minio，4-本地")
    private Integer fileLocation;
    @ChineseDescription("文件仓库(文件夹)")
    private @NotBlank(
            message = "fileBucket不能为空",
            groups = {SysFileInfoRequest.previewByObjectName.class}
    ) String fileBucket;
    @ChineseDescription("文件后缀")
    private String fileSuffix;
    @ChineseDescription("文件大小")
    private Long fileSizeKb;
    @ChineseDescription("存储到bucket中的名称，主键id+.后缀")
    private @NotBlank(
            message = "fileObjectName不能为空",
            groups = {SysFileInfoRequest.previewByObjectName.class}
    ) String fileObjectName;
    @ChineseDescription("存储路径")
    private String filePath;
}

