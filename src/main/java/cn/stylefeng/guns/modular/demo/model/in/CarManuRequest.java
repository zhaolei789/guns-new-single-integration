package cn.stylefeng.guns.modular.demo.model.in;

import cn.stylefeng.roses.kernel.rule.annotation.ChineseDescription;
import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CarManuRequest extends BaseRequest {
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
    @NotBlank(message = "厂商所属颜色不能为空！", groups = {BaseRequest.add.class, BaseRequest.edit.class})
    private String manuCountry;

    @NotNull(message = "状态不能为空", groups = {add.class, edit.class})
    @ChineseDescription("状态")
    private Integer statusFlag;

    /**
     * 车辆价格
     */
    private Integer isDelete;

    @ChineseDescription("厂商id集合（用在批量操作）")
    private @NotNull(
            message = "厂商id集合不能为空",
            groups = {BaseRequest.batchDelete.class}
    ) List<Long> manuIds;


}
