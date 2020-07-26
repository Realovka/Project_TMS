package by.realovka.projectTMS.application;

import by.realovka.projectTMS.util.Autorization;

import java.util.Scanner;

public class EnterView {
    private static String login;
    public static void askForUserNameAndPassword() {
        while (true) {
            System.out.println("Для выхода нажмите ПРОБЕЛ");
            System.out.println("Введите логин");
            Scanner scanner = new Scanner(System.in);
            login = scanner.nextLine();
            if (login.equals(" ")) {
                System.exit(0);
            }
            System.out.println("Введите пароль");
            Scanner scanner1 = new Scanner(System.in);
            String password = scanner1.nextLine();
            if (login.equals(Autorization.getLoginOfAdministrator()) && password.equals(Autorization.getPasswordOfAdministrator())) {
                AdminAndUserView.showMenuForAdministrator();
                break;
            } else if (login.equals(Autorization.getLoginOfUser()) && password.equals(Autorization.getPasswordOfUser())) {
                AdminAndUserView.showMenuForUser();
                break;
            } else System.out.println("Авторизация не пройдена");


        }
    }
}