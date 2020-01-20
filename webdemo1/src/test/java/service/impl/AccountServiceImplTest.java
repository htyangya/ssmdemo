package service.impl;

import htyy.domain.Account;
import htyy.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContextConfig.xml")
public class AccountServiceImplTest {

    @Autowired
    IAccountService as;

    @Autowired
    JdbcTemplate jt;

//    @Before
//    public void getAs(){
//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        as = (IAccountService) ac.getBean("accountService");
//    }


    @Test
    public void findAll() {
        List<Account> accountList = as.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }

    }

    @Test
    public void findAcountById() {
        Account account = as.findAcountById(3);
        System.out.println(account);
    }

    @Test
    public void saveAcount() {
        Account account = new Account();
        account.setName("杨亚");
        account.setMoney(new Float(5000));
        as.saveAcount(account);
    }

    @Test
    public void updateAcount() {
        Account account = as.findAcountById(2);
        account.setName("流放");
        as.updateAcount(account);

    }

    @Test
    public void deleteAcount() {
        as.deleteAcount(2);
    }

    @Test
    public void transfer() {
        as.transfer("aaa","ccc",50);
    }

    @Test
    public void testJdbcTemplate(){
        jt.execute("insert into account(name,money) values('jdbc',2000)");
    }

}