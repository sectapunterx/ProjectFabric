package Fabric.Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

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
                addCodeColumnIfNotExist(connection, "arrivals");
                addCodeColumnIfNotExist(connection, "models");
                addForeignKey(connection, "arrivals");
                addForeignKey(connection, "models");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ошибка подключения к базе данных", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
        return connection;
    }

    private static void addCodeColumnIfNotExist(Connection connection, String tableName) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getColumns(null, null, tableName, "code");
        if (!resultSet.next()) {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + tableName + " ADD COLUMN code INTEGER;");
        }
    }

    private static void addForeignKey(Connection connection, String tableName) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getImportedKeys(connection.getCatalog(), null, tableName);
        boolean foreignKeyExists = false;
        while (resultSet.next()) {
            String fkColumnName = resultSet.getString("FKCOLUMN_NAME");
            if ("code".equals(fkColumnName)) {
                foreignKeyExists = true;
                break;
            }
        }
        if (!foreignKeyExists) {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + tableName + " ADD CONSTRAINT fk_" + tableName + " FOREIGN KEY (code) REFERENCES product(code);");
            //Вывод на экран
        }
    }
}
