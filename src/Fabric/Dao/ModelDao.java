package Fabric.Dao;

import Fabric.Database.DatabaseConnection;
import Fabric.Model;

import java.sql.*;
import java.util.ArrayList;

public class ModelDao {
    private Connection connection;

    public ModelDao() {
        connection = DatabaseConnection.getConnection();
    }

    public ArrayList<Model> getAllModels() throws SQLException {
        String query = "SELECT * FROM models";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Model> models = new ArrayList<>();
        while (resultSet.next()) {
            int codeModel = resultSet.getInt("codemodel");
            String nameModel = resultSet.getString("namemodel");
            int codeProduct = resultSet.getInt("codeproduct");
            double priceModel = resultSet.getDouble("pricemodel");

            models.add(new Model(codeModel, nameModel, codeProduct, priceModel));
        }

        return models;
    }

    public void addModel(Model model) {
        String query = "INSERT INTO models (codemodel, namemodel, codeproduct, pricemodel) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, model.getCodeModel());
            preparedStatement.setString(2, model.getNameModel());
            preparedStatement.setInt(3, model.getCodeProduct());
            preparedStatement.setDouble(4, model.getPriceModel());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error adding model: " + ex.getMessage());
        }
    }

    public void updateModel(Model model) throws SQLException {
        String query = "UPDATE models SET namemodel = ?, codeproduct = ?, pricemodel = ? WHERE codemodel = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, model.getNameModel());
        preparedStatement.setInt(2, model.getCodeProduct());
        preparedStatement.setDouble(3, model.getPriceModel());
        preparedStatement.setInt(4, model.getCodeModel());

        preparedStatement.executeUpdate();
    }

    public void deleteModel(int codeModel) throws SQLException {
        String query = "DELETE FROM models WHERE codemodel = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, codeModel);

        preparedStatement.executeUpdate();
    }

    public Model getModel(int codeModel) throws SQLException {
        String query = "SELECT * FROM models WHERE codemodel = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, codeModel);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String nameModel = resultSet.getString("namemodel");
            int codeProduct = resultSet.getInt("codeproduct");
            double priceModel = resultSet.getDouble("pricemodel");

            return new Model(codeModel, nameModel, codeProduct, priceModel);
        }

        return null;
    }
}

