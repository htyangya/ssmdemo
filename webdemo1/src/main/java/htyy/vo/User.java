package htyy.vo;

import java.security.PrivateKey;

public class User {
    private String name;
    private String psd;
    private Integer money;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", psd='" + psd + '\'' +
                ", money=" + money +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public User() {
    }

}
