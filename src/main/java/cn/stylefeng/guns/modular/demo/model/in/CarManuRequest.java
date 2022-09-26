package cn.stylefeng.guns.modular.demo.model.in;

import cn.stylefeng.roses.kernel.db.api.pojo.entity.BaseEntity;
import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
public class CarManuRequest extends BaseEntity {
    /**
     * 车辆id
     */
    private Long manuId;

    /**
     * 车辆名称
     */
    @NotBlank(message = "厂商名称不能为空！", groups = {BaseRequest.add.class, BaseRequest.edit.class})
    private String manuName;

    /**
     * 车辆类型：1，轿车  2，货车
     */
    @NotBlank(message = "厂商地址不能为空！", groups = {BaseRequest.add.class, BaseRequest.edit.class})
    private String manuAddr;

    /**
     * 车辆颜色
     */
    @NotBlank(message = "厂商所属国际不能为空！", groups = {BaseRequest.add.class, BaseRequest.edit.class})
    private String manuCountry;

    /**
     * 车辆价格
     */
    private Integer is_delete;


}
