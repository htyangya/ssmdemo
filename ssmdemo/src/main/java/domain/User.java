package domain;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private Date birthday;
    private String sex;
    private String address;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    @Cascade({CascadeType.DELETE,CascadeType.SAVE_UPDATE})
    private Set<Account> accounts =new HashSet<Account>();

    @ManyToMany()
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name = "uid"),inverseJoinColumns = @JoinColumn(name = "rid"))
    @Cascade({CascadeType.SAVE_UPDATE})
    private Set<Role> roles=new HashSet<Role>();

    public User() {
    }

    public User(String userName, Date birthday, String sex) {
        this.userName = userName;
        this.birthday = birthday;
        this.sex = sex;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
