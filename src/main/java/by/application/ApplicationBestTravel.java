package by.application;

import by.util.DBConnection;
import by.util.InPut;

import java.util.List;
import java.util.Scanner;


public class ApplicationBestTravel {

    private static String cityOut;
    private static String cityIn;
    private static int passengersOut;
    private static double cargoOut;

    public static void showQuestion() {
        List<String> cities= DBConnection.getCities();
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
}
