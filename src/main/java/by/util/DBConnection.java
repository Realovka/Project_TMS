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
    private static List<City> cities = new ArrayList<>();
    private static List<ViewOfTransport> transports = new ArrayList<>();
    private static List<ViewOfTransport> differentTransports = new ArrayList<>();

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static City getCityOut(String cityOut) {
        City cityFirstOut = new City();
        try (Connection connection = DBConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM cities");
            List<City> cities = new ArrayList<>();
            while (result.next()) {
                City city = new City();
                city.setId(result.getInt("id"));
                city.setName(result.getString("name"));
                city.setLatitude(result.getDouble("latitude"));
                city.setLongitude(result.getDouble("longitude"));
                city.setAirport(result.getBoolean("airport"));
                city.setSeaPort(result.getBoolean("sea_port"));
                city.setContinent(result.getString("continent"));
                cities.add(city);
            }
            for (City item : cities) {
                if (item.getName().equals(cityOut)) {
                    cityFirstOut = item;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityFirstOut;
    }

    public static City getCityIn(String cityIn) {
        City cityFirstIn = new City();
        try (Connection connection = DBConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM cities");
            List<City> cities = new ArrayList<>();
            while (result.next()) {
                City city = new City();
                city.setId(result.getInt("id"));
                city.setName(result.getString("name"));
                city.setLatitude(result.getDouble("latitude"));
                city.setLongitude(result.getDouble("longitude"));
                city.setAirport(result.getBoolean("airport"));
                city.setSeaPort(result.getBoolean("sea_port"));
                city.setContinent(result.getString("continent"));
                cities.add(city);
            }
            for (City item : cities) {
                if (item.getName().equals(cityIn)) {
                    cityFirstIn = item;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityFirstIn;
    }

    public static ViewOfTransport getTransport(int passengersOut, double cargoOut, List<TypeOfTransport> typeOfTransports) {
        List<ViewOfTransport> viewOfTransportList = new ArrayList<>();
        ViewOfTransport max = new ViewOfTransport();

            try (Connection connectionViewOfTransport = DBConnection.getConnection()) {
                PreparedStatement preparedStatement = connectionViewOfTransport.prepareStatement("SELECT * FROM view_of_transport WHERE passengers>=?, cargo>=?, type in (?)");
                List<Integer> transportId=new ArrayList<>();
                for(TypeOfTransport item:typeOfTransports){
                    transportId.add(item.getId());
                }
                Object[] transport = transportId.toArray();
                Array array = connectionViewOfTransport.createArrayOf("INT", transport);
                preparedStatement.setInt(1, passengersOut);
                preparedStatement.setDouble(2, cargoOut);
                preparedStatement.setArray(3, array);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    ViewOfTransport viewOfTransport = new ViewOfTransport();
                    viewOfTransport.setId(resultSet.getInt("id"));
                    viewOfTransport.setName(resultSet.getString("name"));
                    viewOfTransport.setSpeed(resultSet.getInt("speed"));
                    viewOfTransport.setPassengers(resultSet.getInt("passengers"));
                    viewOfTransport.setCargo(resultSet.getDouble("cargo"));
                    viewOfTransport.setPricePerKm(resultSet.getDouble("price_per_km"));
                    viewOfTransportList.add(viewOfTransport);
                }

                int maxSpeed = viewOfTransportList.get(0).getSpeed();
                for (int i = 0; i < viewOfTransportList.size(); i++) {
                    if (viewOfTransportList.get(i).getSpeed() > maxSpeed) {
                        max = viewOfTransportList.get(i);
                    }
                }

            } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return max;
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

    public static List<City> getListCities() {
        try (Connection connection = DBConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM cities");
            while (result.next()) {

                City city = new City();
                city.setId(result.getInt("id"));
                city.setName(result.getString("name"));
                city.setLatitude(result.getDouble("latitude"));
                city.setLongitude(result.getDouble("longitude"));
                city.setAirport(result.getBoolean("airport"));
                city.setSeaPort(result.getBoolean("sea_port"));
                city.setContinent(result.getString("continent"));
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static List<ViewOfTransport> getListTransport() {
        try (Connection connectionViewOfTransport = DBConnection.getConnection()) {
            Statement statementViewOfTransport = connectionViewOfTransport.createStatement();
            ResultSet resultSet = statementViewOfTransport.executeQuery("SELECT* FROM view_of_transport ORDER BY price_per_km");
            while (resultSet.next()) {
                ViewOfTransport transport = new ViewOfTransport();
                transport.setId(resultSet.getInt("id"));
                transport.setName(resultSet.getString("name"));
                transport.setSpeed(resultSet.getInt("speed"));
                transport.setPassengers(resultSet.getInt("passengers"));
                transport.setCargo(resultSet.getDouble("cargo"));
                transport.setPricePerKm(resultSet.getDouble("price_per_km"));
                transports.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transports;
    }

    public static List<ViewOfTransport> getListSeaTransport() {
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
                differentTransports.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return differentTransports;
    }

    public static List<ViewOfTransport> getListGroundTransport() {
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
                differentTransports.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return differentTransports;
    }
}
