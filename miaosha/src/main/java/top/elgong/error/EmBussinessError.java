package top.elgong.error;

public enum EmBussinessError implements CommonError {
    /*枚举类型的。。。*/

    // 通用错误类型
    PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),
    UNKNOWN_ERROR(10002, "未知错误"),

    // 用户模块
    USER_NOT_EXIST(20001, "用户不存在"),


    ;

    private int errCode;
    private String errMsg;

    private EmBussinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrorCode() {
        return this.errCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrorMsg(String Msg) {

        this.errMsg = Msg;
        return this;
    }
}
