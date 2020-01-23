package dao;

import domain.Account;
import domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAccountDao {

    @Select("select a.*,u.id user_id,u.address,u.birthday,u.sex,u.username from account a LEFT JOIN user u on a.userid=u.id")
    List<Account> findAll();

    @Select("select * from account")
    @Results( @Result(property = "user",column = "userid",one = @One(select = "dao.IUserDao.findById",fetchType = FetchType.LAZY)))
    List<Account> findAll_Lazy();

    @Select("select * from account where id=#{id}")
    Account findAccountById(Integer id);

    @Select("select * from account where name like #{name}")
    List<Account> findAccountByName(String name);

    @Select("select * from account where userid = #{userid}")
    List<Account> findAccountByUserId(Integer userid);


    List<Account> findAccountByCondition(Account account);

    @Insert("insert into account(name,money,userid) values(#{name},#{money},#{userid})")
    void saveAccount(Account account);

    @Update("update account set name=#{name},money=#{money} where id=#{id}")
    void updateAccount(Account account);

    @Delete("delete from account where id=#{id}")
    void deleteAccount(Integer id);

    @Select("select count(id) from account")
    int findTotal();
}
