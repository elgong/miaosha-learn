package top.elgong.service;

import top.elgong.controller.viewobject.UserVo;
import top.elgong.error.BussinessException;
import top.elgong.service.model.UserModel;

public interface IUserService {

    /**
     *  根据用户id，获取用户对象
     * @param id
     */
    UserModel getUserById(Integer id);

    void register(UserModel userModel) throws BussinessException;
}

