package Fabric.Dao;

import Fabric.Arrival;
import Fabric.Database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;

public class ArrivalDao {
    private Connection connection;

    public ArrivalDao() {
        connection = DatabaseConnection.getConnection();
    }

    public ArrayList<Arrival> getAllArrivals() throws SQLException {
        String query = "SELECT * FROM arrivals";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Arrival> arrivals = new ArrayList<>();
        while (resultSet.next()) {
            int codeReceipt = resultSet.getInt("codereceipt");
            int codeModel = resultSet.getInt("codemodel");
            Date dateReceipt = resultSet.getDate("datereceipt");
            int quantityReceipt = resultSet.getInt("quantityreceipt");
            String acceptReceipt = resultSet.getString("acceptreceipt");

            arrivals.add(new Arrival(codeReceipt, codeModel, dateReceipt, quantityReceipt, acceptReceipt));
        }

        return arrivals;
    }

    public void addArrival(Arrival arrival) {
        String query = "INSERT INTO arrivals (codereceipt, codemodel, datereceipt, quantityreceipt, acceptreceipt) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, arrival.getCode());
            preparedStatement.setInt(2, arrival.getCodeModel());
            java.sql.Date sqlDate = new java.sql.Date(arrival.getDateReceipt().getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setInt(4, arrival.getQuantityReceipt());
            preparedStatement.setString(5, arrival.getAcceptReceipt());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error adding arrival: " + ex.getMessage());
        }
    }

    public void updateArrival(Arrival arrival) throws SQLException {
        String query = "UPDATE arrivals SET codemodel = ?, datereceipt = ?, quantityreceipt = ?, acceptreceipt = ? WHERE codereceipt = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, arrival.getCodeModel());

        // преобразование java.util.Date в java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(arrival.getDateReceipt().getTime());
        preparedStatement.setDate(2, sqlDate);

        preparedStatement.setInt(3, arrival.getQuantityReceipt());
        preparedStatement.setString(4, arrival.getAcceptReceipt());
        preparedStatement.setInt(5, arrival.getCode());

        preparedStatement.executeUpdate();
    }

    public void deleteArrival(int codeReceipt) throws SQLException {
        String query = "DELETE FROM arrivals WHERE codereceipt = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, codeReceipt);

        preparedStatement.executeUpdate();
    }

    public Arrival getArrival(int codeReceipt) throws SQLException {
        String query = "SELECT * FROM arrivals WHERE codereceipt = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, codeReceipt);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int codeModel = resultSet.getInt("codemodel");
            Date dateReceipt = resultSet.getDate("datereceipt");
            int quantityReceipt = resultSet.getInt("quantityreceipt");
            String acceptReceipt = resultSet.getString("acceptreceipt");

            return new Arrival(codeReceipt, codeModel, dateReceipt, quantityReceipt, acceptReceipt);
        }

        return null;
    }
}
