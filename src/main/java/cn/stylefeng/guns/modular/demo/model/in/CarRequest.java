package cn.stylefeng.guns.modular.demo.model.in;

import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    private String carName;

    /**
     * 车辆类型 1，轿车  2，货车
     */
    @NotNull(message = "车辆类型不能为空！", groups = {add.class, edit.class})
    private Integer carType;
}
