package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {
    /*
        클래스 분리를 통한 관심 분리
        결국 두 클래스 중 한 곳이 다른 한 쪽에 종속되는 결과를 만들어낸다.
     */
    public Connection makeNuewConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/springbook", "root", "root");
    }
}
