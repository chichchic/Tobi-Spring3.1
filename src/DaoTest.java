import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import user.dao.ConnectionMaker;
import user.dao.DaoFactory;
import user.dao.MySqlConnectionMaker;
import user.dao.UserDao;
import user.domain.User;

import java.sql.SQLException;

public class DaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

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
    }
}
