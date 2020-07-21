package by.application;

import by.controller.BestTravel;
//import by.controller.BestTravelBySpeedController;
//import by.controller.BestTravelController;

import java.util.Scanner;

public class ApplicationTwoViewsTravel {

    public static void showTwoViewsTravel(String cityOut, String cityIn, int passengersOut,double cargoOut) {
        System.out.println("Выберите вариант, по которому осуществить поиск транспорта");
        System.out.println("1-Если хотите осуществить самое быстрое перемещение");
        System.out.println("2-Если хотите осуществить самое дешевое перемещение");
        Scanner scanner = new Scanner(System.in);
        int twoViewsTravel = scanner.nextInt();
        switch (twoViewsTravel) {
            case 1: BestTravel.getBestTransportBySpeed(cityOut,cityIn, passengersOut,cargoOut);
                break;


            default:
                System.out.println("Вы ввели неподходящее число");
                ApplicationTwoViewsTravel.showTwoViewsTravel(cityOut, cityIn,  passengersOut, cargoOut);

        }
    }
}