package by.realovka.projectTMS.dao;

import by.realovka.projectTMS.entity.TransportView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTransportTypeDao {
    public static void add(TransportView viewOfTransport) {
        try (Connection connection = DBConnectionDao.getConnection()) {
            String sql = "INSERT INTO view_of_transport (name, speed,passengers,cargo,type,price_per_km) VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, viewOfTransport.getName());
            preparedStatement.setInt(2, viewOfTransport.getSpeed());
            preparedStatement.setInt(3, viewOfTransport.getPassengers());
            preparedStatement.setDouble(4, viewOfTransport.getCargo());
            preparedStatement.setInt(5, viewOfTransport.getTypeOfTransport().getId() );
            preparedStatement.setDouble(6, viewOfTransport.getPricePerKm());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void remove(String viewOfTransport) {
        try (Connection connection = DBConnectionDao.getConnection()) {
            String sql = "DELETE FROM view_of_transport WHERE name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, viewOfTransport);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void update(TransportView viewOfTransport) {
        try (Connection connection = DBConnectionDao.getConnection()) {
            String sql = "UPDATE view_of_transport SET  speed=?,passengers=?,cargo=?,type=?,price_per_km=? WHERE name=? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, viewOfTransport.getSpeed());
            preparedStatement.setInt(2,viewOfTransport.getPassengers());
            preparedStatement.setDouble(3, viewOfTransport.getCargo());
             preparedStatement.setInt(4, viewOfTransport.getTypeOfTransport().getId() );
            preparedStatement.setDouble(5, viewOfTransport.getPricePerKm());
            preparedStatement.setString(6, viewOfTransport.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
