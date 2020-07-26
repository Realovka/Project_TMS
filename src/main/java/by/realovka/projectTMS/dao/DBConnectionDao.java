package by.realovka.projectTMS.dao;

import by.realovka.projectTMS.application.BestTravelView;
import by.realovka.projectTMS.controller.BestTravelController;
import by.realovka.projectTMS.entity.City;
import by.realovka.projectTMS.entity.ReportInformation;
import by.realovka.projectTMS.entity.TransportType;
import by.realovka.projectTMS.entity.TransportView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnectionDao {
    private static final String URL = "jdbc:mysql://localhost:3306/transport?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Vorobei55";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static City getCityOut(String cityOut) {
        City cityFirstOut = new City();
        try (Connection connection = DBConnectionDao.getConnection()) {
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
        try (Connection connection = DBConnectionDao.getConnection()) {
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

    public static List<TransportView> getAllAirTransport() {
        List<TransportView> airTransport = new ArrayList<>();
        try (Connection connectionViewOfTransport = DBConnectionDao.getConnection()) {
            Statement statementViewOfTransport = connectionViewOfTransport.createStatement();
            ResultSet resultSet = statementViewOfTransport.executeQuery("SELECT* FROM view_of_transport WHERE type =2");
            while (resultSet.next()) {
                TransportView transport = new TransportView();
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

    public static List<TransportView> getAllSeaTransport() {
        List<TransportView> seaTransport = new ArrayList<>();
        try (Connection connectionViewOfTransport = DBConnectionDao.getConnection()) {
            Statement statementViewOfTransport = connectionViewOfTransport.createStatement();
            ResultSet resultSet = statementViewOfTransport.executeQuery("SELECT* FROM view_of_transport WHERE type =3");
            while (resultSet.next()) {
                TransportView transport = new TransportView();
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

    public static List<TransportView> getAllGroundTransport() {
        List<TransportView> groundTransport = new ArrayList<>();
        try (Connection connectionViewOfTransport = DBConnectionDao.getConnection()) {
            Statement statementViewOfTransport = connectionViewOfTransport.createStatement();
            ResultSet resultSet = statementViewOfTransport.executeQuery("SELECT* FROM view_of_transport WHERE type =1");
            while (resultSet.next()) {
                TransportView transport = new TransportView();
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
        try (Connection connection = DBConnectionDao.getConnection()) {
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

    public static List<TransportType> getTypeOfTransport() {
        List<TransportType> typeOfTransports = new ArrayList<>();
        try (Connection connection = DBConnectionDao.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM type_of_transport");
            while (result.next()) {
                Integer id = result.getInt("id");
                String name = result.getString("name");
                TransportType typeOfTransport=new TransportType(id,name);
                typeOfTransports.add(typeOfTransport);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeOfTransports;
    }

    public static List<String> getViewOfTransport() {
        List<String> viewOfTransports = new ArrayList<>();
        try (Connection connection = DBConnectionDao.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT name FROM view_of_transport");
            while (result.next()) {
                String viewOfTransport = result.getString("name");
                System.out.println(result.getString("name"));
                viewOfTransports.add(viewOfTransport);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viewOfTransports;
    }

    public static List<ReportInformation> getOrders() {
        List<ReportInformation> reportInformations = new ArrayList<>();
        try (Connection connection = DBConnectionDao.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM history");
            while (result.next()) {
                Integer id = result.getInt("id");
                String nameCityOut = result.getString("city_name_out");
                String nameCityIn = result.getString("city_name_in");
                Integer passengers = result.getInt("passengers");
                Double cargo = result.getDouble("cargo");
                String fastTransport = result.getString("fast_transport");
                String cheapTransport = result.getString("cheap_transport");
                ReportInformation reportInformation=new ReportInformation(id,nameCityOut,nameCityIn,passengers,cargo,fastTransport,cheapTransport);
                reportInformations.add(reportInformation);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reportInformations;
    }

    static  public ReportInformation getReportInformation(){
        City cityOut = DBConnectionDao.getCityOut(BestTravelView.getCityOut());
        City cityIn = DBConnectionDao.getCityIn(BestTravelView.getCityIn());
        int passengersOut = BestTravelView.getPassengersOut();
        List<TransportView> allTransportFromTwoCities = BestTravelController.getAllTransportFromTwoCities(cityOut, cityIn, passengersOut, BestTravelView.getCargoOut());
        try (Connection connection = DBConnectionDao.getConnection()) {
            String sql = "INSERT INTO history (city_name_out, city_name_in, passengers, cargo, fast_transport, cheap_transport) VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, BestTravelView.getCityOut());
            preparedStatement.setString(2, BestTravelView.getCityIn());
            preparedStatement.setInt(3, passengersOut);
            preparedStatement.setDouble(4, BestTravelView.getCargoOut());
            preparedStatement.setString(5, BestTravelController.getBestTransportBySpeed(allTransportFromTwoCities).getName());
            preparedStatement.setString(6, BestTravelController.getBestTransportByPrice(allTransportFromTwoCities).getName());
            preparedStatement.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return new ReportInformation(BestTravelView.getCityOut(), BestTravelView.getCityIn(), passengersOut, BestTravelView.getCargoOut(),
                BestTravelController.getBestTransportBySpeed(allTransportFromTwoCities).getName(),
                BestTravelController.getBestTransportByPrice(allTransportFromTwoCities).getName());
    }

}
