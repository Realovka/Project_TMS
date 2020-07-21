package by.application;

import java.util.Scanner;

public class Application {
    public static void showMenu() {
        System.out.println("Выберите действие");
        System.out.println("1-Подобрать оптимальный маршрут путешествия");
        System.out.println("2-Реализовать функционал по редактированию транспортной компании");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        switch (answer) {
            case 1:
                ApplicationBestTravel.showQuestion();
            case 2:
                ApplicationModificationCompany.showModificationMenu();
        }
    }
}


