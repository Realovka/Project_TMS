package by.realovka.projectTMS.application;

import by.realovka.projectTMS.controller.BestTravelController;
import by.realovka.projectTMS.controller.ReportController;
import by.realovka.projectTMS.dao.DBConnectionDao;

import java.util.Scanner;

public class AdminAndUserView {
    private static boolean flag = true;

    public static void showMenuForAdministrator() {
        while (flag) {
            System.out.println("Выберите действие");
            System.out.println("1-Подобрать оптимальный маршрут путешествия");
            System.out.println("2-Реализовать функционал по редактированию транспортной компании");
            System.out.println("3-Реализовать отчет в виде XML-файла");
            System.out.println("4-Выход в предыдущее меню");
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();
            switch (answer) {
                case 1:
                    BestTravelView.showQuestion();
                    if (BestTravelController.getAllTransportFromTwoCities(DBConnectionDao.getCityOut(BestTravelView.getCityOut()),
                        DBConnectionDao.getCityOut(BestTravelView.getCityIn()), BestTravelView.getPassengersOut(),
                        BestTravelView.getCargoOut()).size()!=0) {
                        DBConnectionDao.getReportInformation();
                    }
                    break;
                case 2:
                    ModificationCompanyView.showModificationMenu();
                    break;
                case 3:
                    ReportController report = new ReportController();
                    Thread thread = new Thread(report);
                    thread.start();
                    AdminAndUserView.showMenuForAdministrator();
                case 4:
                    EnterView.askForUserNameAndPassword();
                    break;
                default:
                    System.out.println("Нет такого действия");
                    AdminAndUserView.showMenuForAdministrator();
            }
        }
    }

    public static void showMenuForUser() {
        while (flag) {
            System.out.println("Выберите действие");
            System.out.println("1-Подобрать оптимальный маршрут путешествия");
            System.out.println("2-Выход в предыдущее меню");
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();
            switch (answer) {
                case 1:
                    BestTravelView.showQuestion();
                    break;
                case 2:
                    EnterView.askForUserNameAndPassword();
                    break;
                default:
                    System.out.println("Нет такого действия");
                    AdminAndUserView.showMenuForUser();
            }
        }
    }
}
