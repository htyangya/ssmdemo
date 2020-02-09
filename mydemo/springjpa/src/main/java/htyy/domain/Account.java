package htyy.domain;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    private Integer userid;
    private String name;
    private  Float money;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "userid")
    @BatchSize(size = 10)
    private User user;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
//                ", userid=" + userid +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public User getUser() {
        return user;
    }

//    public Integer getUserid() {
//        return userid;
//    }

//    public void setUserid(Integer userid) {
//        this.userid = userid;
//    }

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
