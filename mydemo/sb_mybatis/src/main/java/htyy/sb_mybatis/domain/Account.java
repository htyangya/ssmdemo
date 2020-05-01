package htyy.sb_mybatis.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table
@JsonIgnoreProperties(value = {"handler"})
public class Account implements Serializable {


    private static final long serialVersionUID = -179971926684471361L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userid;
    private String name;
    private  Float money;
    private User user;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userid=" + userid +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public User getUser() {
        return user;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }


}
