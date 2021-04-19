package user.dao;

public class DaoFactory {
    public UserDao userDao() {
        return new UserDao(mysqlConnectionMaker());
    }
    public ConnectionMaker mysqlConnectionMaker(){
        return new MySqlConnectionMaker();
    }
}
