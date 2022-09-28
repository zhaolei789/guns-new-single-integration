package cn.stylefeng.guns.modular.demo.model.Enum;

public enum DelFlagEnum {

    Y("Y", "是"),
    N("N", "否");
    private final String code;
    private final String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    DelFlagEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
