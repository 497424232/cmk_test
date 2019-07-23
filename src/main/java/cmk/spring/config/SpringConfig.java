package cmk.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @auther changmk
 * @date 2019/7/23 下午8:06
 */
@Configuration//把当前类当做spring配置类
@ComponentScan("cmk.spring")
public class SpringConfig {


    @Bean("dataSource")
    public DataSource getDataSource() {
        DataSource dataSource = null;
        return dataSource;
    }
}
