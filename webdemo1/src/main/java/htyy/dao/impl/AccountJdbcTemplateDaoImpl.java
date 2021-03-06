package htyy.dao.impl;

import htyy.dao.IAccountDao;
import htyy.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


public class AccountJdbcTemplateDaoImpl implements IAccountDao {


    JdbcTemplate jt;

    public void  findByxb(){
        System.out.println("这是服务器端坐的修改，代码位置已经和本地不一样，从底部到顶部，打印内容也变化了。");
    }

    public List<Account> findAll() {
        return jt.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
    }

    public Account findAcountById(Integer id) {
        List<Account> accounts = jt.query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class),id);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public Account findAccountByname(String name) {
        //此方法和dbutils有区别，因为重载了多个方法，可以自动根据sql语句决定返回泛型、集合或者void
        List<Account> accounts = jt.query("select * from account where name like ?", new BeanPropertyRowMapper<Account>(Account.class),name);
        if (accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一，数据有误");
        }
        return accounts.get(0);
    }

    public void saveAcount(Account account) {
        jt.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
    }

    public void  findBybendiadd(){
        System.out.println("这是本地的新增，测试中间的代码能否被merge。");
    }

    public void updateAcount(Account account) {
        jt.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }

    public void deleteAcount(Integer id) {
        jt.update("delete from account where id=?",id);
    }

}
