import domain.Account;
import domain.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Jpatest {

    static EntityManager manager;
    static EntityTransaction transaction;
    static EntityManagerFactory factory;

    @BeforeClass
    public static void  init(){
//        Configuration configuration=new Configuration().configure();
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        session = sessionFactory.getCurrentSession();
//        transaction = session.beginTransaction();
        factory = Persistence.createEntityManagerFactory("myJpa");
        manager = factory.createEntityManager();
        transaction = manager.getTransaction();
        transaction.begin();
    }
    @AfterClass
    public static void close(){
//        transaction.commit();
////        session.close();
        transaction.commit();
        manager.close();
        factory.close();
    }
    @Test
    public void testsave(){
        Account account = new Account();
        account.setMoney(2001f);
        account.setName("mybatis-annotasion");
        User user = new User();
        user.setUserName("天皇号");
        user.getAccounts().add(account);
        account.setUser(user);
//        session.save(user);
        manager.persist(account);
    }

    @Test
    public  void testRemove(){
        manager.remove(manager.find(User.class,60));
    }

    @Test
    public  void testJPQL(){
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        List<Object[]> resultList = manager.createQuery("from Account a inner join a.user").getResultList();
        for (Object[] obj : resultList) {
            System.out.println(Arrays.toString(obj));
        }
    }

    @Test
    public  void testFetchJPQL(){
        List<Account> resultList = manager.createQuery("from Account a inner join fetch a.user").getResultList();
        for (Account obj : resultList) {
            System.out.println(obj);
            System.out.println(obj.getUser());
        }
    }

}
