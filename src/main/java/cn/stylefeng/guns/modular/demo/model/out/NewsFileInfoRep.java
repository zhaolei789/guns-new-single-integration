package cn.stylefeng.guns.modular.demo.model.out;

import cn.stylefeng.roses.kernel.file.api.pojo.request.SysFileInfoRequest;
import cn.stylefeng.roses.kernel.rule.annotation.ChineseDescription;
import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 文件信息(NewsFileInfo)表实体类
 *
 * @author makejava
 * @since 2022-10-18 17:28:37
 */
@SuppressWarnings("serial")
@Data
public class NewsFileInfoRep implements Serializable {
    private static final long serialVersionUID = -1L;
    @ChineseDescription("文件id")
    private Long fileId;
    @ChineseDescription("文件编码")
    private Long fileCode;
    @ChineseDescription("是否为机密文件，Y-是机密，N-不是机密")
    private String secretFlag;
    @ChineseDescription("文件名称（上传时候的文件全名，例如：开发文档.txt）")
    private String fileOriginName;
    @ChineseDescription("其他文件形式参数")
    private String token;
    @ChineseDescription("文件存储位置：1-阿里云，2-腾讯云，3-minio，4-本地")
    private Integer fileLocation;
    @ChineseDescription("文件仓库(文件夹)")
    private String fileBucket;
    @ChineseDescription("文件后缀")
    private String fileSuffix;
    @ChineseDescription("文件大小")
    private Long fileSizeKb;
    @ChineseDescription("存储到bucket中的名称，主键id+.后缀")
    private String fileObjectName;
    @ChineseDescription("存储路径")
    private String filePath;
    @ChineseDescription("文件访问的url")
    private String fileUrl;
    @ChineseDescription("创建人")
    private Long createAccountId;
    @ChineseDescription("创建人部门id")
    private Long createDeptId;
    @ChineseDescription("创建人姓名")
    private String createUserName;
    @ChineseDescription("创建时间")
    private Date createTime;
    @ChineseDescription("创建人姓名")
    private String realName;
    @ChineseDescription("文件版本")
    private Integer fileVersion;
    @ChineseDescription("文件应用Code名称")
    private String fileAppCodeName;
}

