package cn.stylefeng.guns.modular.demo.model.in;

import cn.stylefeng.roses.kernel.db.api.pojo.entity.BaseEntity;
import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (TNews)表实体类
 *
 * @author RestfulToolkitXCode
 * @since 2022-10-17 17:00:29
 */

@Data
public class NewsReq extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    //新闻id
    private Long newsId;
    //新闻标题
    private String newsTitle;
    //新闻名称
    private String newsName;
    //紧急程度
    private Integer newsCode;
    //完成时间
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date doneTime;
    //删除标识
    private String delFlag;
    //详情
    private String newsDetail;

    private @NotNull(
            message = "新闻id集合不能为空",
            groups = {BaseRequest.batchDelete.class}
    ) List<Long> newsIds;
}

