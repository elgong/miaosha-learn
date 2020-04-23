package top.elgong.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.elgong.error.BussinessException;
import top.elgong.error.EmBussinessError;
import top.elgong.response.CommonReturnType;
import top.elgong.service.IUserService;
import top.elgong.service.model.UserModel;
import top.elgong.controller.viewobject.UserVo;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

@Controller()
@RequestMapping("/user")
//@CrossOrigin  // 解决跨域请求？？？？？
@CrossOrigin(origins = {"*"},allowedHeaders = "true")
public class UserController extends BaseController{

    @Autowired
    IUserService userService;

    // 默认是  threadLocal 类型， 用户线程间独立
    @Autowired
    HttpServletRequest httpServletRequest;

    /*
    *  验证码登陆
    * */
    @RequestMapping(value = "/getotp", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORM})
    @ResponseBody  // 返回数据
    public CommonReturnType getOTP(@RequestParam(name = "telephone") String telephone) throws BussinessException {

        // 生成otp验证码
        Random random = new Random();

        int randomInt = 0;

        while ((randomInt = random.nextInt(99999)) < 10000){
            ;
        }

        String otpCode = String.valueOf(randomInt);

        // 将验证码与手机关联， 借助redis 或者session
        httpServletRequest.getSession().setAttribute(telephone, otpCode);

        // 短信发送到用户手机上
        // 敏感信息，不能打印
        System.out.println("telephone " + telephone + " &otp" + otpCode);

        return CommonReturnType.create(null);
    }

    /*用户的注册*/

    public CommonReturnType register(@RequestParam(name = "nickname") String nickname,
                                     @RequestParam(name = "telephone") String telephone,
                                     @RequestParam(name = "gender") Integer gender,
                                     @RequestParam(name = "age") Integer age,
                                     @RequestParam(name = "optCode") String optCode) throws BussinessException {
        // 验证手机号 和对应的  optCode
        String telephoneInSession = (String)this.httpServletRequest.getSession().getAttribute("telephone");

        if (telephone == null || !telephoneInSession.equals(telephone)){
            throw new BussinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR, "短信验证码不符合");
        }

        // 注册流程


        return null;
    }

    @RequestMapping("/get")
    @ResponseBody  // 返回数据
    public CommonReturnType getUserById(Model model, @RequestParam(value = "id", required = true)Integer id) throws BussinessException {

        // 调用 service 服务 获取对应 id 的用户对象返回给前端
        UserModel userModel = userService.getUserById(id);

        if (userModel == null){

            throw new BussinessException(EmBussinessError.USER_NOT_EXIST);
        }

        UserVo userVo = convertFromUserModel(userModel);

        return CommonReturnType.create(userVo);

    }


    /**
     *  核心用户模型  转换成 前端用的 VO 对象
     * @param userModel
     * @return
     */
    private UserVo convertFromUserModel(UserModel userModel){

        if (userModel == null){
            return null;
        }

        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userModel, userVo);

        return userVo;
    }

}
