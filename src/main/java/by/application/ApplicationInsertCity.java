package by.application;

import by.entity.City;
import by.util.InPut;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ApplicationInsertCity {
    private static List<String> continents = Arrays.asList("Евразия", "Северная Америка", "Африка", "Австралия", "Антарктида", "Южная Америка");

    public static City setCity() {
        Boolean airportCity = false;
        Boolean seaPortCity = false;
        boolean airportFlag = true;
        boolean seaPortFlag = true;
        boolean flag = true;
        String continent=null;
        System.out.println("Введите название города");
        Scanner scanner = new Scanner(System.in);
        String cityName = scanner.nextLine();
        System.out.println("Введите широту, где расположен город");
        Scanner scanner1 = new Scanner(System.in);
        Double latitudeCity = InPut.getDouble(scanner1);
        System.out.println("Введите долготу, где расположен город");
        Scanner scanner2 = new Scanner(System.in);
        Double longitudeCity = InPut.getDouble(scanner2);
        while (airportFlag) {
            System.out.println("Есть ли в городе аэропорт?");
            Scanner scanner3 = new Scanner(System.in);
            List<Boolean> list = InPut.getBooleanCollection(scanner3);
            airportCity = list.get(1);
            airportFlag = list.get(0);
        }
        while (seaPortFlag) {
            System.out.println("Есть ли в городе морской порт?");
            Scanner scanner3 = new Scanner(System.in);
            List<Boolean> list = InPut.getBooleanCollection(scanner3);
            seaPortCity = list.get(1);
            seaPortFlag = list.get(0);
        }
        for (String item : continents) {
            System.out.println(item);
        }
        while (flag) {
            System.out.println("На каком континенте находится город?");
            Scanner scanner3 = new Scanner(System.in);
            continent = scanner3.nextLine();
            flag = InPut.getContinent(continent, continents);
        }
        return new City(cityName, latitudeCity, longitudeCity, airportCity, seaPortCity, continent);

    }
}
