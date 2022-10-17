package cn.stylefeng.guns.modular.demo.entity;

import cn.stylefeng.roses.kernel.db.api.pojo.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;


@TableName("car_manu")
@Data
@EqualsAndHashCode(callSuper = true)
public class CarManuEntity extends BaseEntity {
    /**
     * 车辆id
     */
    @TableId("manu_id")
    private Long manuId;

    /**
     * 车辆名称
     */
    @TableField("manu_name")
    private String manuName;

    /**
     * 车辆类型：1，轿车  2，货车
     */
    @TableField("manu_addr")
    private String manuAddr;

    /**
     * 车辆颜色
     */
    @TableField("manu_country")
    private String manuCountry;

    /**
     * 车辆价格
     */
    @TableField("is_delete")
    private Integer isDelete;

    /**
     * 状态
     */
    @TableField("status_flag")
    private Integer statusFlag;

    @TableField("file_path")
    private String filePath;
}
