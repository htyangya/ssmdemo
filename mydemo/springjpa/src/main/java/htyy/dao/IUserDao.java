package htyy.dao;

import htyy.domain.Account;
import htyy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * JpaRepository<Account,Integer> 封装了基本crud操作，泛型为要操作的实体对象和该实体对象的主键类型
 *  JpaSpecificationExecutor<Account> 封装了复杂查询（分页等）
 */
@Repository
public interface IUserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {


}
