package user.dao;

public class DaoFactory {
    public UserDao userDao() {
        ConnectionMaker connectionMaker = new MySqlConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }
}
