package by.realovka.projectTMS.dao;

import by.realovka.projectTMS.entity.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBCityDao {
    public static void add(City city) {
        try (Connection connection = DBConnectionDao.getConnection()) {
            String sql = "INSERT INTO cities (name, latitude,longitude,airport,sea_port,continent) VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, city.getName());
            preparedStatement.setDouble(2, city.getLatitude());
            preparedStatement.setDouble(3, city.getLongitude());
            preparedStatement.setBoolean(4, city.isAirport());
            preparedStatement.setBoolean(5, city.isSeaPort());
            preparedStatement.setString(6, city.getContinent());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void remove(String city) {
        try (Connection connection = DBConnectionDao.getConnection()) {
            String sql = "DELETE FROM cities WHERE name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, city);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void update(City city) {
        try (Connection connection = DBConnectionDao.getConnection()) {
            String sql = "UPDATE cities SET latitude=?, longitude=?, airport=?, sea_port=?, continent=? WHERE name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, city.getLatitude());
            preparedStatement.setDouble(2, city.getLongitude());
            preparedStatement.setBoolean(3, city.isAirport());
            preparedStatement.setBoolean(4, city.isSeaPort());
            preparedStatement.setString(5, city.getContinent());
            preparedStatement.setString(6, city.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
