package htyy.service;

import htyy.domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();

    Account findAcountById(Integer id);

    void saveAcount(Account account);

    void updateAcount(Account account);

    void deleteAcount(Integer id);

    /**
     *
     * @param sourceName 转入账户
     * @param targetName 转出账户
     * @param money 金额
     */
    void transfer(String sourceName, String targetName, float money);
}
