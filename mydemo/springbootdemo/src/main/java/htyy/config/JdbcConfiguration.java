package htyy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({JdbcProperties.class})//设置读取的自动注入类
public class JdbcConfiguration {

    private JdbcProperties jdbcProperties;

    public JdbcConfiguration(JdbcProperties jdbcProperties) {
        this.jdbcProperties = jdbcProperties;
    }

    @Bean
    public JdbcProperties jdbcProperties(@Qualifier("JdbcProperties") JdbcProperties jdbcProperties){
        return jdbcProperties;
    }
//
//    @Bean(name = "jp")
//    @ConfigurationProperties("spring.datasource")
//    public JdbcProperties jdbcProperties1(){
//        return new JdbcProperties();
//    }

}
