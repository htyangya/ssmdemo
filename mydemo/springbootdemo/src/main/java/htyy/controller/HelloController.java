package htyy.controller;

import htyy.config.JdbcProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ConfigurationProperties("person")
public class HelloController {
    @Autowired
    private JdbcProperties jdbcProperties;
    private String name;
    private String city;
    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(String name){

        return "hello my friend,welcome to my zone!\n"+this.name+this.city+this.age+jdbcProperties;
    }

}
