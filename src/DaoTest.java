import user.dao.ConnectionMaker;
import user.dao.MySqlConnectionMaker;
import user.dao.UserDao;
import user.domain.User;

import java.sql.SQLException;

public class DaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionMaker connectionMaker = new MySqlConnectionMaker();
        UserDao dao = new UserDao(connectionMaker);

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
