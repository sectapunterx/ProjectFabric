package Fabric.Dao;

import Fabric.Database.DatabaseConnection;
import Fabric.Product;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private Connection connection;

    public ProductDao() {
        connection = DatabaseConnection.getConnection();
    }

    public List<Product> getAllProducts() throws SQLException {
        String query = "SELECT * FROM products";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Product> productList = new ArrayList<>();

        while (resultSet.next()) {
            int code = resultSet.getInt("code");
            String name = resultSet.getString("name");
            productList.add(new Product(code, name));
        }

        return productList;
    }

    public void addProduct(Product product) {
        String query = "INSERT INTO products (code, name) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, product.getCode());
            preparedStatement.setString(2, product.getName());

            if (!checkIfCodeExistsInOtherTables(product.getCode())) {
                insertEmptyRowsIntoOtherTables(product.getCode());
                System.out.println("Были созданы пустые строки с кодом " + product.getCode() + " в таблицах arrivals и models. Пожалуйста, заполните их.");
            }
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error adding product: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ошибка добавления товара\n" + ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
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


    private boolean checkIfCodeExistsInOtherTables(int code) {
        String checkQuery = "SELECT 1 FROM arrivals WHERE code = ? UNION SELECT 1 FROM models WHERE code = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(checkQuery)) {
            preparedStatement.setInt(1, code);
            preparedStatement.setInt(2, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("Error checking code: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ошибка проверки кода\n" + ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    public void insertEmptyRowsIntoOtherTables(int productCode) {
        String insertArrivalsQuery = "INSERT INTO arrivals(code) VALUES (?)";
        String insertModelsQuery = "INSERT INTO models(code) VALUES (?)";

        try {
            PreparedStatement arrivalsStatement = connection.prepareStatement(insertArrivalsQuery);
            arrivalsStatement.setString(1, String.valueOf(productCode));
            arrivalsStatement.executeUpdate();

            PreparedStatement modelsStatement = connection.prepareStatement(insertModelsQuery);
            modelsStatement.setString(1, String.valueOf(productCode));
            modelsStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "В таблицах 'arrivals' и 'models' были созданы пустые строки с кодом " + productCode + ". Пожалуйста, заполните их.\n Используйте кнопку изменения записи", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ошибка при создании пустых строк в таблицах 'arrivals' и 'models'\n" + e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}