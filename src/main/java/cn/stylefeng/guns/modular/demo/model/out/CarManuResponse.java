package cn.stylefeng.guns.modular.demo.model.out;

import cn.stylefeng.roses.kernel.rule.annotation.ChineseDescription;
import lombok.Data;

@Data
public class CarManuResponse {

    @ChineseDescription("厂商编号")
    private Long manuId;

    @ChineseDescription("厂商名称")
    private String manuName;

    @ChineseDescription("厂商地址")
    private String manuAddr;

    @ChineseDescription("厂商所属国家")
    private String manuCountry;

    @ChineseDescription("状态")
    private Integer statusFlag;

    @ChineseDescription("数量")
    private Integer num;
}
