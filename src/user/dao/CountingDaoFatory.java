package user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class CountingDaoFatory {
    @Bean
    public UserDao setUserDao() {
        UserDao userDao = new UserDao();
        userDao.setDataSource(dataSource());
        return userDao;
    }

    @Bean
    public DataSource dataSource() {
        return new CountingSimpleDataSource(realDataSourceMaker());
    }

    @Bean
    public DataSource realDataSourceMaker() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost/springbook");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
}
