package cn.stylefeng.guns.modular.demo.entity;

import cn.stylefeng.roses.kernel.db.api.pojo.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@TableName("car")
@Data
@EqualsAndHashCode(callSuper = true)
public class CarEntity extends BaseEntity {
    /**
     * 车辆id
     */
    @TableId("car_id")
    private Long carId;

    /**
     * 车辆名称
     */
    @TableField("car_name")
    private String carName;

    /**
     * 车辆类型：1，轿车  2，货车
     */
    @TableField("car_type")
    private Integer carType;

    /**
     * 车辆颜色
     */
    @TableField("car_color")
    private String carColor;

    /**
     * 车辆价格
     */
    @TableField("car_price")
    private BigDecimal carPrice;

    /**
     * 制造商
     */
    @TableField("manufacturer")
    private String manufacturer;

}
