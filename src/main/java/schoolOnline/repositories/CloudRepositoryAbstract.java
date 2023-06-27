package schoolOnline.repositories;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CloudRepositoryAbstract {
    public static Connection createCon() {
        final String url = "jdbc:postgresql://localhost:5432/shema";
        final String username = "postgres";
        final String password = "sasasa";
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

























