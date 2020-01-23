package dao;

import domain.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

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
