package by.realovka.projectTMS.application;

import by.realovka.projectTMS.dao.DBCityDao;
import by.realovka.projectTMS.dao.DBTypeOfTransportDao;

import java.util.Scanner;

public class ModificationCompanyView {
    public static void showModificationMenu() {
        System.out.println("Какой функционал хотите реализовать?");
        System.out.println("1-добавить город");
        System.out.println("2-удалить город");
        System.out.println("3-редактировать город");
        System.out.println("4-добавить транспорт");
        System.out.println("5-удалить транспорт");
        System.out.println("6-редактировать транспорт");
        System.out.println("7-выход в предыдущее меню");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                DBCityDao.add(InsertOrUpdateCityView.setOrUpdateCity(choice));
                break;
            case 2:
                DBCityDao.remove(DeleteCityView.deleteCity());
                break;
            case 3:
                DBCityDao.update(InsertOrUpdateCityView.setOrUpdateCity(choice));
                break;
            case 4:
                DBTypeOfTransportDao.add(InsertOrUpdateTransportView.setOrUpdate(choice));
                break;
            case 5:
                DBTypeOfTransportDao.remove(DeleteTransportView.deleteViewOfTransport());
                break;
            case 6:
                DBTypeOfTransportDao.update(InsertOrUpdateTransportView.setOrUpdate(choice));
                break;
            case 7:
                EnterView.askForUserNameAndPassword();
                break;
            default:
                System.out.println("Нет такого действия");
                ModificationCompanyView.showModificationMenu();


        }
    }
}
