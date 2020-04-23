package top.elgong.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.elgong.entity.UserDO;
import top.elgong.service.model.UserModel;

@Mapper
public interface UserDao {

    @Select("select * from miaosha_user where id = #{id}")
    UserDO selectUserById(@Param("id")Integer id);
}
