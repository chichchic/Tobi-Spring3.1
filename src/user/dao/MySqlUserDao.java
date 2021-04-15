package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlUserDao extends UserDao{
    /*
        상속을 통해 관심이 다른 기능을 분리했다.
        하지만, 상속은 여전히 두 가지 다른 관심사에 대해 긴밀한 결합을 허용한다.
        1. 슈퍼클래스 내부의 변경이 있을 때 모든 서브클래스를 함께 수정하거나 다시 개발해야할 수 있다.
        2. 서브 클래스로 확장된 기능을 다른 클래스에 적용할 수 없다.(중복 발생)
     */
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String DB_URL = "jdbc:mysql://localhost/springbook";
        String USER_NAME = "root";
        String PASSWORD = "root";

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }
}
