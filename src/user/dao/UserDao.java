package user.dao;

import user.domain.User;

import java.sql.*;

public class UserDao {
    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();
        // 관심사 2: 사용자 등록을 위해 DB에 보낼 SQL문을 담은 Statement를 만들고 실행
        PreparedStatement ps =
                c.prepareStatement("INSERT INTO users(id, name, password) values(?, ? ,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());
        ps.executeUpdate();

        // 관심사 3: 작업이 끝나면 사용한 리소스 오브젝트를 담아서 소중한 공유 리소스를 돌려주는 것.
        ps.close();
        c.close();

        // 그 외: 예외 처리x,
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps =
                c.prepareStatement("SELECT * FROM users WHERE id = ?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }
}
