package cn.stylefeng.guns.modular.demo.entity;

import java.io.Serializable;

import cn.stylefeng.roses.kernel.db.api.pojo.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @TableName t_store
 */
@TableName("t_store")
@Data
@EqualsAndHashCode(callSuper = true)
public class Store extends BaseEntity implements Serializable {
    /**
     * 门店id
     */
    @TableId("store_id")
    private Long storeId;

    /**
     * 门店名称
     */
    @TableField("store_name")
    private String storeName;

    /**
     * 门店地址
     */
    @TableField("store_address")
    private String storeAddress;

    /**
     * 门店编码
     */
    @TableField("store_code")
    private String storeCode;

    /**
     * 厂商id
     */
    @TableField("manu_id")
    private Long manuId;

    /**
     * 删除标识
     */
    @TableField("del_flag")
    private String delFlag;

    /**
     * 门店状态
     */
    @TableField("store_stat")
    private Integer storeStat;

    private static final long serialVersionUID = 1L;

}