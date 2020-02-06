import domain.Account;
import domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


public class hibernatedemotest {
    static Transaction transaction;
    static  Session session;

    @BeforeClass
    public static void  init(){
        Configuration configuration=new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
    }

    @AfterClass
    public static void close(){
        transaction.commit();
        session.close();
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
        session.save(account);
    }

    @Test
    public void testdelete(){

        session.delete(session.get(User.class,59));
    }


    @Test
    public void testselectAll(){
        Query query = session.createQuery("from Account where name like :name");
        query.setParameter("name","%");
//        query.setFetchSize(0);
//        query.setMaxResults(5);
        List<Account> accounts = query.list();
        for (Account account : accounts) {
            System.out.println(account);
//            System.out.println(account.getUser());
        }
    }

    @Test
    public void testSelectUser() {
        Query query = session.createQuery("select new User (u.userName,u.birthday,u.sex) from User u");
        List<User> list = query.list();
        for (User user : list) {
            System.out.println(user);
        }

    }

    @Test
    public void testsqlselect() {
        NativeQuery sqlQuery = session.createSQLQuery("select * from user");
        sqlQuery.addEntity(User.class);
        List<User> list = sqlQuery.list();
        for (User user : list) {
            System.out.println(user);
            System.out.println(user.getRoles());
        }

    }

    @Test
    public void testjoinselect() {
        List<Account> list = session.createQuery("select distinct a from Account a inner join fetch a.user").list();
        for (Account objs : list) {
            System.out.println(objs);
            System.out.println(objs.getUser());
        }

    }
    @Test
    public void testgroup() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        detachedCriteria.add(Restrictions.like("userName","杨%"));
        Criteria criteria = detachedCriteria.getExecutableCriteria(session);
        List<User> list = criteria.list();
        for (User user : list) {
            System.out.println(user);
        }

    }


    @Test
    public void testQBC(){
//        获取工厂对象
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        获取针对某个表的条件对象，相当于指定返回值的封装类型
        CriteriaQuery<Account> criteriaQuery = criteriaBuilder.createQuery(Account.class);
//        指定根条件，相当于写from语句
        Root<Account> root = criteriaQuery.from(Account.class);
//        指定查询条件，相当于写where语句,多条件用工厂的and或or链接
        Predicate equal1 = criteriaBuilder.like(root.<String>get("name"),"杨%");
        Predicate lt1 = criteriaBuilder.gt(root.<Number>get("money"), 1000);
        criteriaQuery.where(criteriaBuilder.and(equal1,lt1));
//        指定排序
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")), criteriaBuilder.asc(root.get("userid")));

//       使用session执行查询语句，与hql一致了
        Query<Account> query = session.createQuery(criteriaQuery);
        query.setFirstResult(0);
        query.setMaxResults(5);
        List<Account> accounts = query.list();
        for (Account account : accounts) {
            System.out.println(account);
        }

    }

}
