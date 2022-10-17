package cn.stylefeng.guns.modular.demo.model.Enum;

public enum FileEnum {

    Y("Y", "文件为空"),
    N("N", "文件存在");
    private final String code;
    private final String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    FileEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
