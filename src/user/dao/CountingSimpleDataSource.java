package user.dao;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class CountingSimpleDataSource extends SimpleDriverDataSource {
    private int counter = 0;
    private DataSource realDataSource;

    public CountingSimpleDataSource(DataSource realDataSource) {
        this.realDataSource = realDataSource;
    }

    @Override
    public Connection getConnection() throws SQLException {
        counter++;
        return realDataSource.getConnection();
    }

    public int getCounter() {
        return counter;
    }
}
