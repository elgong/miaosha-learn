package top.elgong.error;
/*
*  包装器业务异常类实现
*
* */

/*
*   异常会被 controller 层的 handler 捕获和处理
* */
public class BussinessException extends Exception implements CommonError {

    private CommonError commonError;

    /*  直接接受 EmBussinessError 的传参，用于构造业务异常*/
    public BussinessException(CommonError commonError){
        // 务必调用
        super();
        this.commonError = commonError;
    }

    // 接受自定义 errorMsg 方式构造
    public BussinessException(CommonError commonError, String Msg){
        // 务必调用
        super();
        this.commonError = commonError;
        this.commonError.setErrorMsg(Msg);

    }

    @Override
    public int getErrorCode() {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return this.commonError.getErrorMsg();
    }

    @Override
    public CommonError setErrorMsg(String Msg) {
        this.commonError.setErrorMsg(Msg);
        return this;
    }
}
