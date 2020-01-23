package dao;

import domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import static org.junit.Assert.*;

public class IAccountDaoTest {
    static InputStream in;
    static SqlSession sqlSession;
    static IAccountDao accountDao;

    @BeforeClass
    public static void init() throws IOException {
        // 通过mybatis提供的resources工具类得到配置文件的流，然后使用工厂构建器构建使用该配置文件构建出的工厂
        in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 工厂生产session对象，这里我们主要使用的对象，该对象可以生产代理dao,并且一个session是一个事务
        sqlSession = factory.openSession();
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @AfterClass
    public  static void close() throws IOException {

//      释放资源：由于流并不是給包装类使用的，这里注意要关闭流。
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }


    @Test
    public void findAll() {
        //        使用getmapper方法获得代理dao

        List<Account> all = accountDao.findAll();
        for (Account account : all) {
            System.out.println(account);
        }

    }

    @Test
    public void findAccountById() {
        System.out.println(accountDao.findAccountById(5));
    }

    @Test
    public void findAccountByName() {
        List<Account> accounts = accountDao.findAccountByName("杨%");
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void saveAcount() {
        Account account = new Account();
        account.setName("annotation-1");
        account.setMoney(300f);
        account.setUserid(43);
        accountDao.saveAccount(account);
        System.out.println("保存成功");
        findAll();
    }

    @Test
    public void updateAcount() {
        Account account = new Account();
        account.setName("mybatis-annotation-update");
        account.setMoney(400f);
        account.setId(13);
        accountDao.updateAccount(account);
        System.out.println("更新成功");
        findAll();
    }

    @Test
    public void deleteAccount() {
        accountDao.deleteAccount(13);
        System.out.println("删除成功！");
    }

    @Test
    public void findTotal() {
        System.out.println(accountDao.findTotal());
    }

    @Test
    public void findAccountByCondition() {
        Account account = new Account();
        account.setName("张%");
//        account.setMoney(3000f);
//        account.setId(9);
        List<Account> accounts = accountDao.findAccountByCondition(account);
        for (Account accountx : accounts) {
            System.out.println(accountx);
        }
    }

    @Test
    public void findAll_Lazy() {
        List<Account> accounts = accountDao.findAll_Lazy();
//        System.out.println(accounts.get(0).getUser());
//        System.out.println(accounts.get(2));
        for (Account account : accounts) {
            System.out.println(account.getName()+account.toString());
//            System.out.println(account.getUser());
        }
    }
}
