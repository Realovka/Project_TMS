package by.util;

import by.entity.City;
import by.entity.ViewOfTransport;
import by.util.Calсulation;

public class Message {
    public static void getMessageAboutTravel(String sortingOption, String cityOut, String cityIn, int passengersOut, double cargoOut, ViewOfTransport viewOfTransport, City cityFirstOut, City cityFirstIn){
        System.out.printf("Самый %s транспорт для доставки %d человек и %.2f т груза из %s в %s - это %s, время в пути %.2f часа, цена %.2f долларов", sortingOption,
                passengersOut, cargoOut, cityOut, cityIn, viewOfTransport.getName(), Calсulation.getDistance(cityFirstOut.getLatitude(), cityFirstOut.getLongitude(),
                        cityFirstIn.getLatitude(), cityFirstIn.getLongitude()) / viewOfTransport.getSpeed(),
                Calсulation.getDistance(cityFirstOut.getLatitude(), cityFirstOut.getLongitude(),
                        cityFirstIn.getLatitude(), cityFirstIn.getLongitude())*viewOfTransport.getPricePerKm()*passengersOut);
    }
}

