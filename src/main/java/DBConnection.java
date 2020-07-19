import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static  final String URL="jdbc:mysql://localhost:3306/transport?serverTimezone=UTC";
    private static  final String USER="root";
    private static  final String PASSWORD="Vorobei55";
    private static List<City> cities=new ArrayList<>();
    private static   List<ViewOfTransport> transports=new ArrayList<>();
    private static   List<ViewOfTransport> differentTransports =new ArrayList<>();

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    public static List<City> getListCities(){
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

    public static List<ViewOfTransport> getListTransport(){
        try (Connection connectionViewOfTransport = DBConnection.getConnection()) {
            Statement statementViewOfTransport = connectionViewOfTransport.createStatement();
            ResultSet resultSet = statementViewOfTransport.executeQuery("SELECT* FROM view_of_transport");
            while (resultSet.next()) {
                ViewOfTransport transport = new ViewOfTransport();
                transport.setId(resultSet.getInt("id"));
                transport.setName(resultSet.getString("name"));
                transport.setSpeed(resultSet.getInt("speed"));
                transport.setPassengers(resultSet.getInt("passengers"));
                transport.setCargo(resultSet.getInt("cargo"));
                transport.setPricePerKm(resultSet.getDouble("price_per_km"));
                transports.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transports;
    }

    public static List<ViewOfTransport> getListSeaTransport(){
        try (Connection connectionViewOfTransport = DBConnection.getConnection()) {
            Statement statementViewOfTransport = connectionViewOfTransport.createStatement();
            ResultSet resultSet = statementViewOfTransport.executeQuery("SELECT* FROM view_of_transport WHERE type =3");
            while (resultSet.next()) {
                ViewOfTransport transport = new ViewOfTransport();
                transport.setId(resultSet.getInt("id"));
                transport.setName(resultSet.getString("name"));
                transport.setSpeed(resultSet.getInt("speed"));
                transport.setPassengers(resultSet.getInt("passengers"));
                transport.setCargo(resultSet.getInt("cargo"));
                transport.setPricePerKm(resultSet.getDouble("price_per_km"));
                differentTransports.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return differentTransports;
    }

    public static List<ViewOfTransport> getListGroundTransport(){
        try (Connection connectionViewOfTransport = DBConnection.getConnection()) {
            Statement statementViewOfTransport = connectionViewOfTransport.createStatement();
            ResultSet resultSet = statementViewOfTransport.executeQuery("SELECT* FROM view_of_transport WHERE type =1");
            while (resultSet.next()) {
                ViewOfTransport transport = new ViewOfTransport();
                transport.setId(resultSet.getInt("id"));
                transport.setName(resultSet.getString("name"));
                transport.setSpeed(resultSet.getInt("speed"));
                transport.setPassengers(resultSet.getInt("passengers"));
                transport.setCargo(resultSet.getInt("cargo"));
                transport.setPricePerKm(resultSet.getDouble("price_per_km"));
                differentTransports.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return differentTransports;
    }
}
