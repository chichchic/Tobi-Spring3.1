package user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    /*
        인터페이스를 통한 관심 분리
     */
    Connection makeConnection() throws ClassNotFoundException, SQLException;
}
