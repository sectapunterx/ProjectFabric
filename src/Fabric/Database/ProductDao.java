package Fabric.Database;

import Fabric.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
    private Connection connection;

    public ProductDao() {
        connection = DatabaseConnection.getConnection();
    }

    public ArrayList<Product> getAllProducts() throws SQLException {
        String query = "SELECT * FROM products";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            int code = resultSet.getInt("code");  // Изменяем здесь
            String name = resultSet.getString("name");

            products.add(new Product(code, name));
        }

        return products;
    }

    // Здесь могут быть другие методы для чтения, обновления и удаления товаров
    // Добавляем новый метод для добавления продукта
    public void addProduct(Product product) throws SQLException {
        String query = "INSERT INTO products (code, name) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        // Устанавливаем параметры запроса
        preparedStatement.setInt(1, product.getCode());
        preparedStatement.setString(2, product.getName());

        // Выполняем запрос
        preparedStatement.executeUpdate();
    }
}
