package by.dao;

import by.entity.City;
import by.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBCityDao {
    public static void add(City city){
            try(Connection connection= DBConnection.getConnection()) {
                String sql="INSERT INTO cities (name, latitude,longitude,airport,sea_port,continent) VALUES(?,?,?,?,?,?)";
                PreparedStatement preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setString(1, city.getName());
                preparedStatement.setDouble(2, city.getLatitude());
                preparedStatement.setDouble(3, city.getLongitude());
                preparedStatement.setBoolean(4,city.isAirport());
                preparedStatement.setBoolean(5,city.isSeaPort());
                preparedStatement.setString(6,city.getContinent());
                preparedStatement.execute();
            } catch (SQLException e){
                e.printStackTrace();
            }

        }
    }

