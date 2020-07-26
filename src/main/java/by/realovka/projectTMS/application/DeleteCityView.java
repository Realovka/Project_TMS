package by.realovka.projectTMS.application;

import by.realovka.projectTMS.dao.DBConnectionDao;
import by.realovka.projectTMS.util.InPut;

import java.util.List;
import java.util.Scanner;

public class DeleteCityView {
    private static boolean cityDelete=true;
    private static String city;

    public static String deleteCity(){
        List<String> cities= DBConnectionDao.getCities();
        while (cityDelete) {
            System.out.println("Выберите из списка город, который хотите удалить");
            Scanner scanner = new Scanner(System.in);
            city = scanner.nextLine();
            cityDelete=InPut.getCity(cities, city);
        }
        cityDelete=true;
        return city;
    }
}
