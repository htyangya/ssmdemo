package htyy.dao;

import htyy.domain.Account;
import htyy.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationConfig.xml")
public class AccountDaoTest {
    @Autowired
    private  IAccountDao accountDao;

    @Autowired
    private  IUserDao userDao;

    @Test
    public void testFindById(){
        Optional<Account> byId = accountDao.findById(3);
        Account account = byId.get();
    }
    @Test
    public void testsave(){
        Account account = new Account();
        account.setMoney(2008f);
        account.setName("spring-data-jpa");
        User user = new User();
        user.setUserName("天皇号");
        user.getAccounts().add(account);
        account.setUser(user);
//        session.save(user);
        accountDao.save(account);
    }

    @Test
    public void testUpdate(){
        Account account = accountDao.findById(24).orElse(null);
        account.setMoney(520f);
        accountDao.save(account);
//        accountDao.deleteById(2);
//        accountDao.delete();
    }

    @Test
    @Transactional
    public void testFindAll(){
        List<Account> all = accountDao.findAll();
        for (Account account : all) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    @Transactional
    public void testSpesification(){
        Sort orders = new Sort(Sort.Direction.DESC, "money", "id");
        Sort orders1 = orders.and(new Sort(Sort.Direction.ASC, "name"));
        PageRequest pageRequest = PageRequest.of(0, 2, orders1);
        Page<Account> pageinfo = accountDao.findAll((Specification<Account>) (root, query, cb) ->
                cb.and(cb.like(root.get("name"), "杨%"),cb.gt(root.get("money"),1000f)),pageRequest);
        System.out.println(pageinfo.getTotalElements());
        System.out.println(pageinfo.getTotalPages());
        System.out.println(pageinfo.getNumber());
        System.out.println(pageinfo.getSize());
        for (Account account : pageinfo.getContent()) {
            System.out.println(account);
            System.out.println(account.getUser());
        }

    }

    @Test
    @Transactional
    public void test(){
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
}
