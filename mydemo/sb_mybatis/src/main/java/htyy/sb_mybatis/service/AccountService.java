package htyy.sb_mybatis.service;

import htyy.sb_mybatis.dao.IAccountDao;
import htyy.sb_mybatis.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private IAccountDao accountDao;

    public Account findAccountByid(Integer id){
        return accountDao.selectByPrimaryKey(id);
    }
    public List<Account> findAllLazy(){
        return accountDao.findAll_Lazy();
    }
    public List<Account> findAll(){
        return accountDao.selectAll();
    }

}
