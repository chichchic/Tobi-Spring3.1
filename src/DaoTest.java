import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import user.dao.*;
import user.domain.User;

import java.sql.SQLException;

public class DaoTest {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFatory.class);
        UserDao dao = context.getBean("setUserDao", UserDao.class);

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("maarried");

        dao.add(user);

        System.out.println(user.getId() + " Register Success");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user.getId() + " Inquiry Success");

        CountingSimpleDataSource csds = context.getBean("dataSource", CountingSimpleDataSource.class);
        System.out.println("Connection counter: " + csds.getCounter());
    }
}
