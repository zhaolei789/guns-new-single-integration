package cn.stylefeng.guns.modular.demo.model.Enum;

import cn.stylefeng.guns.core.consts.ProjectConstants;
import cn.stylefeng.roses.kernel.rule.constants.RuleConstants;
import cn.stylefeng.roses.kernel.rule.exception.AbstractExceptionEnum;
import lombok.Getter;

@Getter
public enum CarExceptionEnum implements AbstractExceptionEnum {
    CAR_NOT_EXISTED(RuleConstants.USER_OPERATION_ERROR_TYPE_CODE + ProjectConstants.BUSINESS_EXCEPTION_STEP_CODE + "01", "车辆不存在"),
    MANU_NOT_EXISTED(RuleConstants.USER_OPERATION_ERROR_TYPE_CODE + ProjectConstants.BUSINESS_EXCEPTION_STEP_CODE + "02", "厂家不存在"),
    UPDATE_STATUS_ERROR("00", "更新厂商状态错误"),

    FILE_NOT_EXISTED("01", "文件为空");
    private final String errorCode;
    private final String userTip;

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getUserTip() {
        return this.userTip;
    }
    private CarExceptionEnum(String errorCode, String userTip) {
        this.errorCode = errorCode;
        this.userTip = userTip;
    }

}
