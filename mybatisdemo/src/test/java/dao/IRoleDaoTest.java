package dao;

import domain.Role;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class IRoleDaoTest {
    static InputStream in;
    static SqlSession sqlSession;
    static IRoleDao roleDao;

    @BeforeClass
    public static void init() throws IOException {
        // 通过mybatis提供的resources工具类得到配置文件的流，然后使用工厂构建器构建使用该配置文件构建出的工厂
        in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 工厂生产session对象，这里我们主要使用的对象，该对象可以生产代理dao,并且一个session是一个事务
        sqlSession = factory.openSession();
        roleDao = sqlSession.getMapper(IRoleDao.class);
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
        List<Role> all = roleDao.findAll();
        for (Role role : all) {
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }

    @Test
    public void findById() {
        System.out.println(roleDao.findById(3));
    }
}