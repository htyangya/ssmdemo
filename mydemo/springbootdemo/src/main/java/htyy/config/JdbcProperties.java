package htyy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("spring.datasource")
public class JdbcProperties {
    private String url;
    private String data_username;
    private String data_password;
    private String driver_class_name;

    @Override
    public String toString() {
        return "JdbcProperties{" +
                "url='" + url + '\'' +
                ", data_username='" + data_username + '\'' +
                ", data_password='" + data_password + '\'' +
                ", driver_class_name='" + driver_class_name + '\'' +
                '}';
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setData_username(String data_username) {
        this.data_username = data_username;
    }

    public void setData_password(String data_password) {
        this.data_password = data_password;
    }

    public void setDriver_class_name(String driver_class_name) {
        this.driver_class_name = driver_class_name;
    }


}
