package Fabric.Dao;

import Fabric.Database.DatabaseConnection;
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
            int code = resultSet.getInt("code");
            String name = resultSet.getString("name");

            products.add(new Product(code, name));
        }

        return products;
    }

    public void addProduct(Product product) {
    String query = "INSERT INTO products (code, name) VALUES (?, ?)";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, product.getCode());
        preparedStatement.setString(2, product.getName());
        preparedStatement.executeUpdate();
    } catch (SQLException ex) {
        System.err.println("Error adding product: " + ex.getMessage());
    }
}

    public void updateProduct(Product product) throws SQLException {
        String query = "UPDATE products SET name = ? WHERE code = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, product.getName());
        preparedStatement.setInt(2, product.getCode());

        preparedStatement.executeUpdate();
    }

    public void deleteProduct(int code) throws SQLException {
        String query = "DELETE FROM products WHERE code = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, code);

        preparedStatement.executeUpdate();
    }

    public Product getProduct(int code) throws SQLException {
        String query = "SELECT * FROM products WHERE code = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, code);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            return new Product(code, name);
        }

        return null;
    }
}
