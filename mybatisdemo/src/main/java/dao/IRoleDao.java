package dao;

import domain.Role;
import domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {

    List<Role> findAll();

    @Select("select * from role where roleId=#{id}")
    Role findById(Integer id);

}
