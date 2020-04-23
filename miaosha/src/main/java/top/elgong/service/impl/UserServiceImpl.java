package top.elgong.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.elgong.dao.UserDao;
import top.elgong.entity.UserDO;
import top.elgong.error.BussinessException;
import top.elgong.error.EmBussinessError;
import top.elgong.service.IUserService;
import top.elgong.service.model.UserModel;
import top.elgong.controller.viewobject.UserVo;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserModel getUserById(Integer id) {

        // 得到 userDO 数据
        UserDO userDO = userDao.selectUserById(id);

        if (userDO == null){
            return null;
        }

        // 转换成 Model
        UserModel userModel = convertFromUserDO(userDO);


        // 向控制器传递 Model
        return userModel;
    }

    @Override
    public void register(UserModel userModel) throws BussinessException {
        if (userModel == null){
            throw new BussinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR);
        }

    }


    /**
     *  将 DO 转换成 Model
     * @param userDO
     * @return
     */
    private UserModel convertFromUserDO(UserDO userDO){

        if (userDO == null) {
            return null;
        }

        UserModel userModel = new UserModel();

        BeanUtils.copyProperties(userDO, userModel);

        return userModel;
    }
}
