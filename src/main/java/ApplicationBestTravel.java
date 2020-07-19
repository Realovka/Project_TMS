
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ApplicationBestTravel {

    List<String> cities = new ArrayList<>();
    private String cityOut;
    private String cityIn;
    private int passengersOut;
    private double cargoOut;

    public void showQuestion() {
        getCities();
        boolean flagCityOut = true;
        boolean flagCityIn = true;

        while (flagCityOut) {
            System.out.println("Выберите из списка город, из которого нужно уехать ");
            Scanner scanner = new Scanner(System.in);
            cityOut = scanner.nextLine();
            flagCityOut = InPut.getCity(cities, cityOut);
        }
        while (flagCityIn) {
            System.out.println("Выберите из списка город, в который нужно уехать ");
            Scanner scanner = new Scanner(System.in);
            cityIn = scanner.nextLine();
            flagCityIn = InPut.getCity(cities, cityIn);
        }

        System.out.println("Введите цифрой количество пассажиров ");
        Scanner scanner = new Scanner(System.in);
        passengersOut = InPut.getInt(scanner);
        System.out.println("Введите цифрой массу перевозимого груза в тоннах. Можно дробное число ");
        Scanner scanner1 = new Scanner(System.in);
        cargoOut = InPut.getDouble(scanner1);

        ApplicationTwoViewsTravel.showTwoViewsTravel(cityOut, cityIn, passengersOut, cargoOut);


    }


    public void getCities() {
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
    }
}
