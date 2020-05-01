package htyy.sb_mybatis.dao;


import htyy.sb_mybatis.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface IUserDao {

    @Select("select * from user")
    @Results({
            @Result(property="id", column="id",id = true),
            @Result(property="userName", column="userName"),
            @Result(property="birthday", column="birthday"),
            @Result(property="sex", column="sex"),
            @Result(property="address", column="address"),
            @Result(property = "accounts",column = "id",
                    many = @Many(fetchType = FetchType.LAZY,select = "dao.IAccountDao.findAccountByUserId"))

    })
    List<User> findAll();

    @Select("select * from user where id=#{id}")
    User findById(Integer id);

}
