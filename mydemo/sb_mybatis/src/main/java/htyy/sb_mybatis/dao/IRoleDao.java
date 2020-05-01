package htyy.sb_mybatis.dao;


import htyy.sb_mybatis.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IRoleDao {

    List<Role> findAll();

    @Select("select * from role where roleId=#{id}")
    Role findById(Integer id);

}
