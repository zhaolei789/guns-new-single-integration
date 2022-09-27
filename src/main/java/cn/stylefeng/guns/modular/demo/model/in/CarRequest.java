package cn.stylefeng.guns.modular.demo.model.in;

import cn.stylefeng.roses.kernel.rule.annotation.ChineseDescription;
import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CarRequest extends BaseRequest {
    /**
     * 车辆id
     */
    private long carId;

    /**
     * 车辆名称
     */
    @NotBlank(message = "车辆名称不能为空！", groups = {add.class, edit.class})
    @ChineseDescription("车辆名称")
    private String carName;

    /**
     * 车辆类型 1，轿车  2，货车
     */
    @ChineseDescription("车辆类型")
    @NotNull(message = "车辆类型不能为空！", groups = {add.class, edit.class})
    private Integer carType;

    /**
     * 车辆颜色
     */
    @ChineseDescription("车辆颜色")
    @NotBlank(message = "车辆颜色不能为空！", groups = {add.class, edit.class})
    private String carColor;

    /**
     * 车辆价格
     */
    @ChineseDescription("车辆价格")
    @NotNull(message = "车辆价格不能为空！", groups = {add.class, edit.class})
    private BigDecimal carPrice;

    /**
     * 制造商
     */
    @ChineseDescription("制造商")
    @NotBlank(message = "制造商不能为空！", groups = {add.class, edit.class})
    private String manufacturer;


    /**
     * 车辆id集合
     */
    @ChineseDescription("车辆id集合（用在批量操作）")
    private @NotNull(
            message = "车辆id集合不能为空",
            groups = {BaseRequest.batchDelete.class}
    ) List<Long> carIds;
}
