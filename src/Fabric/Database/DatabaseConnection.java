package Fabric.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    private static password passwd = new password();

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver"); // Загрузка драйвера PostgreSQL
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/fabric", // URL соединения
                        "postgres", // Имя пользователя
                        passwd.pass  // Пароль
                );
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }
}
