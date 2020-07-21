package by.application;

import by.dao.DBCityDao;

import java.util.Scanner;

public class ApplicationModificationCompany {
    public static void showModificationMenu(){
        System.out.println("Какой функционал хотите реализовать?");
        System.out.println("1-добавить город");
        System.out.println("2-удалить город");
        System.out.println("3-редактировать город");
        System.out.println("4-добавить транспорт");
        System.out.println("5-удалить транспорт");
        System.out.println("6-редактировать транспорт");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                DBCityDao.add(ApplicationInsertCity.setCity());

        }
    }
}
