import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import user.dao.*;
import user.domain.User;

import java.sql.SQLException;

public class DaoTest {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new GenericXmlApplicationContext("countingApplicationContext.xml");
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("white ship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        System.out.println("Register Success");

        User user2 = dao.get(user.getId());

        if(!user.getName().equals(user2.getName())){
            System.out.println("Test Fail :: (name)");
        }
        else if(!user.getPassword().equals(user2.getPassword())) {
            System.out.println("Test Fail :: (password)");
        }
        else {
            System.out.println("Inquiry Success");
        }
    }
}
