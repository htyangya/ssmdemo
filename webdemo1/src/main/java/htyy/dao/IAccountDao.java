package htyy.dao;

import htyy.domain.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountDao {

    @Select("select * from account")
    List<Account> findAll();

    @Select("select * from account where id=#{id}")
    Account findAcountById(Integer id);

    @Select("select * from account where name=#{name}")
    Account findAccountByname(String name);

    void saveAcount(Account account);

    void updateAcount(Account account);

    void deleteAcount(Integer id);
}
