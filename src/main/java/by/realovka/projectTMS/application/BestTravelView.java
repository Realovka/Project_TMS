package by.realovka.projectTMS.application;

import by.realovka.projectTMS.controller.BestTravelController;
import by.realovka.projectTMS.dao.DBConnectionDao;
import by.realovka.projectTMS.util.InPut;

import java.util.List;
import java.util.Scanner;


public class BestTravelView {

    private static String cityOut;
    private static String cityIn;
    private static int passengersOut;
    private static double cargoOut;
    private static boolean flagCityOut = true;
    private static boolean flagCityIn = true;

    public static String getCityOut() {
        return cityOut;
    }

    public static void setCityOut(String cityOut) {
        BestTravelView.cityOut = cityOut;
    }

    public static String getCityIn() {
        return cityIn;
    }

    public static void setCityIn(String cityIn) {
        BestTravelView.cityIn = cityIn;
    }

    public static int getPassengersOut() {
        return passengersOut;
    }

    public static void setPassengersOut(int passengersOut) {
        BestTravelView.passengersOut = passengersOut;
    }

    public static double getCargoOut() {
        return cargoOut;
    }

    public static void setCargoOut(double cargoOut) {
        BestTravelView.cargoOut = cargoOut;
    }

    public static void showQuestion() {
        List<String> cities= DBConnectionDao.getCities();

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
        flagCityIn=true;
        flagCityOut=true;
        System.out.println("Введите цифрой количество пассажиров ");
        Scanner scanner = new Scanner(System.in);
        passengersOut = InPut.getInt(scanner);
        System.out.println("Введите цифрой массу перевозимого груза в тоннах. Можно дробное число ");
        Scanner scanner1 = new Scanner(System.in);
        cargoOut = InPut.getDouble(scanner1);

        BestTravelController.getBestTransport(cityOut,cityIn,passengersOut,cargoOut);


    }
}
