package htyy.dao;

import htyy.domain.Account;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();

    Account findAcountById(Integer id);

    /**
     *
     * @param name 账户名称
     * @return 若结果集不存在，返回null；若结果不唯一，报错。
     */
    Account findAccountByname(String name);

    void saveAcount(Account account);

    void updateAcount(Account account);

    void deleteAcount(Integer id);
}
