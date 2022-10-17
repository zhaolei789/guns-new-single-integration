package cn.stylefeng.guns.modular.demo.entity;

import java.util.Date;

import cn.stylefeng.roses.kernel.db.api.pojo.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * (TNews)表实体类
 *
 * @author RestfulToolkitXCode
 * @since 2022-10-17 17:00:29
 */
@TableName("t_news")
@Data
@EqualsAndHashCode(callSuper = true)
public class News extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    //新闻id
    @TableId("news_id")
    private Long newsId;
    //新闻标题
    @TableField("news_title")
    private String newsTitle;
    //新闻名称
    @TableField("news_name")
    private String newsName;
    //紧急程度
    @TableField("news_code")
    private Integer newsCode;
    //完成时间
    @TableField("done_time")
    private Date doneTime;
    //删除标识
    @TableField("del_flag")
    private String delFlag;
    //详情
    @TableField("news_detail")
    private String newsDetail;
}

