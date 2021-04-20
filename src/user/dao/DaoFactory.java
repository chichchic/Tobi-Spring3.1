package user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setConnectionMaker(mysqlConnectionMaker());
        return userDao;
    }

    @Bean
    public ConnectionMaker mysqlConnectionMaker() {
        return new MySqlConnectionMaker();
    }
}
