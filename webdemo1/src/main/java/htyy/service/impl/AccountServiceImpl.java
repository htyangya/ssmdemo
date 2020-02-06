package htyy.service.impl;

import com.github.pagehelper.PageHelper;
import htyy.dao.IAccountDao;
import htyy.domain.Account;
import htyy.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        PageHelper.startPage(1,5);
        return accountDao.findAll();
    }

    public Account findAcountById(Integer id) {
        return accountDao.findAcountById(id);
    }

    public void saveAcount(Account account) {
        accountDao.saveAcount(account);
    }

    public void updateAcount(Account account) {
        accountDao.updateAcount(account);

    }

    public void deleteAcount(Integer id) {
        accountDao.deleteAcount(id);

    }

    public void transfer(String sourceName, String targetName, float money) {
        Account source = accountDao.findAccountByname(sourceName);
        Account target = accountDao.findAccountByname(targetName);
        source.setMoney(source.getMoney()-money);
//        int i=1/0;
        target.setMoney(target.getMoney()+money);
        accountDao.updateAcount(source);
        accountDao.updateAcount(target);
    }
}
