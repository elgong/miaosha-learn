package top.elgong.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import top.elgong.error.BussinessException;
import top.elgong.error.EmBussinessError;
import top.elgong.response.CommonReturnType;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/*
*
*  所有controller 的共有方法
*
* */
public class BaseController {

    public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";

    /* 定义 exceptionHandler , 拦截异常*/
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody   //加上后，才能返回数据
    public Object handlerException(HttpServletRequest request, Exception ex){

        /*这里的hashmap 不太合适*/
        HashMap<String, Object> responseData = new HashMap<>();

        if (ex instanceof BussinessException){

            BussinessException bussinessException = (BussinessException) ex;
            responseData.put("errCode", bussinessException.getErrorCode());
            responseData.put("errMsg", bussinessException.getErrorMsg());
        } else {
            responseData.put("errCode", EmBussinessError.UNKNOWN_ERROR.getErrorCode());
            responseData.put("errMsg", EmBussinessError.UNKNOWN_ERROR.getErrorMsg());
        }


        return CommonReturnType.create(responseData, "fail");
    }
}
