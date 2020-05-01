package htyy.sb_mybatis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.core.convert.converter.Converter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    //添加自定义过滤器
    public void addInterceptors(InterceptorRegistry registry) {
    }

    @Override
    //添加自定义类型转换器
    public void addFormatters(FormatterRegistry registry) {

    }
}
