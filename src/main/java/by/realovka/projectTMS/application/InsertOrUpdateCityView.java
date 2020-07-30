package by.realovka.projectTMS.application;

import by.realovka.projectTMS.entity.City;
import by.realovka.projectTMS.dao.DBConnectionDao;
import by.realovka.projectTMS.util.InPut;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InsertOrUpdateCityView {

    private static List<String> continents = Arrays.asList("Евразия", "Северная Америка", "Африка", "Австралия", "Антарктида", "Южная Америка");
    private static boolean airportCity = false;
    private static boolean seaPortCity = false;
    private static boolean airportFlag = true;
    private static boolean seaPortFlag = true;
    private static boolean cityDelete = true;
    private static boolean flag = true;
    private static String continent;
    private static String cityName;

    public static City setOrUpdateCity(int choice) {
        switch (choice) {
            case 1:
                insertCity();
                break;
            case 3:
                updateCity();
                break;
        }
        System.out.println("Введите широту, где расположен город");
        Scanner latitudeScanner = new Scanner(System.in);
        double latitudeCity = InPut.getDouble(latitudeScanner);
        System.out.println("Введите долготу, где расположен город");
        Scanner longitudeScanner = new Scanner(System.in);
        double longitudeCity = InPut.getDouble(longitudeScanner);
        while (airportFlag) {
            System.out.println("Есть ли в городе аэропорт?");
            Scanner airportIsScanner = new Scanner(System.in);
            List<Boolean> list = InPut.getBooleanCollection(airportIsScanner);
            airportCity = list.get(1);
            airportFlag = list.get(0);
        }
        airportFlag=true;
        while (seaPortFlag) {
            System.out.println("Есть ли в городе морской порт?");
            Scanner seaPortIsScanner = new Scanner(System.in);
            List<Boolean> list = InPut.getBooleanCollection(seaPortIsScanner);
            seaPortCity = list.get(1);
            seaPortFlag = list.get(0);
        }
        seaPortFlag=true;
        for (String item : continents) {
            System.out.println(item);
        }
        while (flag) {
            System.out.println("На каком континенте находится город?");
            Scanner continentScanner = new Scanner(System.in);
            continent = continentScanner.nextLine();
            flag = InPut.getContinent(continent, continents);
        }
        flag=true;
        return new City(cityName, latitudeCity, longitudeCity, airportCity, seaPortCity, continent);

    }

    public static String insertCity() {
        System.out.println("Введите название города");
        Scanner insertCityNameScanner = new Scanner(System.in);
        cityName = insertCityNameScanner.nextLine();
        return cityName;
    }

    public static String updateCity() {
        List<String> cities = DBConnectionDao.getCities();
        while (cityDelete) {
            System.out.println("Выберите из списка город, который хотите редактировать");
            Scanner updateCityScanner = new Scanner(System.in);
            cityName = updateCityScanner.nextLine();
            cityDelete = InPut.getCity(cities, cityName);
        }
        cityDelete=true;
        return cityName;
    }
}
