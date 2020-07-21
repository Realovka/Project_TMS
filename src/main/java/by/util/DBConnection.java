package by.util;

import by.entity.City;
import by.entity.TypeOfTransport;
import by.entity.ViewOfTransport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/transport?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Vorobei55";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static City getCityOut(String cityOut) {
        City cityFirstOut = new City();
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM cities WHERE name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cityOut);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {

                cityFirstOut.setId(result.getInt("id"));
                cityFirstOut.setName(result.getString("name"));
                cityFirstOut.setLatitude(result.getDouble("latitude"));
                cityFirstOut.setLongitude(result.getDouble("longitude"));
                cityFirstOut.setAirport(result.getBoolean("airport"));
                cityFirstOut.setSeaPort(result.getBoolean("sea_port"));
                cityFirstOut.setContinent(result.getString("continent"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityFirstOut;
    }

    public static City getCityIn(String cityIn) {
        City cityFirstIn = new City();
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM cities WHERE name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cityIn);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {

                cityFirstIn.setId(result.getInt("id"));
                cityFirstIn.setName(result.getString("name"));
                cityFirstIn.setLatitude(result.getDouble("latitude"));
                cityFirstIn.setLongitude(result.getDouble("longitude"));
                cityFirstIn.setAirport(result.getBoolean("airport"));
                cityFirstIn.setSeaPort(result.getBoolean("sea_port"));
                cityFirstIn.setContinent(result.getString("continent"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityFirstIn;
    }

    public static List<ViewOfTransport> getAllAirTransport() {
        List<ViewOfTransport> airTransport = new ArrayList<>();
        try (Connection connectionViewOfTransport = DBConnection.getConnection()) {
            Statement statementViewOfTransport = connectionViewOfTransport.createStatement();
            ResultSet resultSet = statementViewOfTransport.executeQuery("SELECT* FROM view_of_transport WHERE type =2");
            while (resultSet.next()) {
                ViewOfTransport transport = new ViewOfTransport();
                transport.setId(resultSet.getInt("id"));
                transport.setName(resultSet.getString("name"));
                transport.setSpeed(resultSet.getInt("speed"));
                transport.setPassengers(resultSet.getInt("passengers"));
                transport.setCargo(resultSet.getDouble("cargo"));
                transport.setPricePerKm(resultSet.getDouble("price_per_km"));
                airTransport.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airTransport;
    }

    public static List<ViewOfTransport> getAllSeaTransport() {
        List<ViewOfTransport> seaTransport = new ArrayList<>();
        try (Connection connectionViewOfTransport = DBConnection.getConnection()) {
            Statement statementViewOfTransport = connectionViewOfTransport.createStatement();
            ResultSet resultSet = statementViewOfTransport.executeQuery("SELECT* FROM view_of_transport WHERE type =3");
            while (resultSet.next()) {
                ViewOfTransport transport = new ViewOfTransport();
                transport.setId(resultSet.getInt("id"));
                transport.setName(resultSet.getString("name"));
                transport.setSpeed(resultSet.getInt("speed"));
                transport.setPassengers(resultSet.getInt("passengers"));
                transport.setCargo(resultSet.getDouble("cargo"));
                transport.setPricePerKm(resultSet.getDouble("price_per_km"));
                seaTransport.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seaTransport;
    }

    public static List<ViewOfTransport> getAllGroundTransport() {
        List<ViewOfTransport> groundTransport = new ArrayList<>();
        try (Connection connectionViewOfTransport = DBConnection.getConnection()) {
            Statement statementViewOfTransport = connectionViewOfTransport.createStatement();
            ResultSet resultSet = statementViewOfTransport.executeQuery("SELECT* FROM view_of_transport WHERE type =1");
            while (resultSet.next()) {
                ViewOfTransport transport = new ViewOfTransport();
                transport.setId(resultSet.getInt("id"));
                transport.setName(resultSet.getString("name"));
                transport.setSpeed(resultSet.getInt("speed"));
                transport.setPassengers(resultSet.getInt("passengers"));
                transport.setCargo(resultSet.getDouble("cargo"));
                transport.setPricePerKm(resultSet.getDouble("price_per_km"));
                groundTransport.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groundTransport;
    }

    public static List<String> getCities() {
        List<String> cities = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT name FROM cities");
            while (result.next()) {
                String city = result.getString("name");
                System.out.println(result.getString("name"));
                cities.add(city);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

}
