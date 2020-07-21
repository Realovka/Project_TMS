package by.controller;

import by.entity.ViewOfTransport;
import by.util.DBConnection;
import by.entity.City;
import by.util.Message;

import java.util.ArrayList;
import java.util.List;


public class BestTravel {
    private static final String SORTBYSPEED="быстрый";
    private static final String SORTBYPRICE="дешевый";
    public static void getBestTransport(String cityOut, String cityIn, int passengersOut, double cargoOut, int twoViewsTravel) {

        City cityFirstOut = DBConnection.getCityOut(cityOut);
        City cityFirstIn = DBConnection.getCityIn(cityIn);
        List<ViewOfTransport> viewOfTransportList = getAllTransportFromTwoCities(cityFirstOut, cityFirstIn, passengersOut, cargoOut);

        if (viewOfTransportList == null) {
            System.out.println("Путешествие невозможно, так как города на разных континентах, и как минимум в одном из них нет ни аэропорта, ни морского порта");
            return;
        }

        switch (twoViewsTravel) {
            case 1:
                ViewOfTransport transportBySpeed=BestTravel.getBestTransportBySpeed(viewOfTransportList);
                if (transportBySpeed.getName()==null){
                    System.out.println("Путешествие невозможно, так как такое количество груза и(или) количество пассажиров невозможно перевезти ни на одном виде транспорта");
                    return;
                }
                Message.getMessageAboutTravel(SORTBYSPEED, cityOut, cityIn, passengersOut, cargoOut, transportBySpeed, cityFirstOut, cityFirstIn);
                break;
            case 2:
                ViewOfTransport transportByPrice=BestTravel.getBestTransportByPrice(viewOfTransportList);
                if (transportByPrice.getName()==null){
                    System.out.println("Путешествие невозможно, так как такое количество груза и(или) количество пассажиров невозможно перевезти ни на одном виде транспорта");
                    return;
                }
                Message.getMessageAboutTravel(SORTBYPRICE, cityOut, cityIn, passengersOut, cargoOut, BestTravel.getBestTransportByPrice(viewOfTransportList), cityFirstOut, cityFirstIn);
                break;
        }

    }

    private static List<ViewOfTransport> getAllTransportFromTwoCities(City cityFirstOut, City cityFirstIn, int passengersOut, double cargoOut) {
        List<ViewOfTransport> differentTransports = new ArrayList<>();
        List<ViewOfTransport> transportsYouCanUse = new ArrayList<>();
        if (cityFirstOut.isAirport() && cityFirstIn.isAirport()) {
            differentTransports.addAll(DBConnection.getAllAirTransport());
        }
        if (cityFirstOut.isSeaPort() && cityFirstIn.isSeaPort()) {
            differentTransports.addAll(DBConnection.getAllSeaTransport());
        }
        if (cityFirstOut.getContinent().equals(cityFirstIn.getContinent())) {
            differentTransports.addAll(DBConnection.getAllGroundTransport());
        }

        if(differentTransports.size()==0){
            return null;
        }

        for (ViewOfTransport item : differentTransports) {
            if (item.getPassengers() >= passengersOut && item.getCargo() >= cargoOut) {
                transportsYouCanUse.add(item);
            }
        }

        return transportsYouCanUse;
    }


    private static ViewOfTransport getBestTransportBySpeed(List<ViewOfTransport> transportsYouCanUse) {
        ViewOfTransport maxSpeed = new ViewOfTransport();
        for (ViewOfTransport item1 : transportsYouCanUse) {
            if (item1.getSpeed() > maxSpeed.getSpeed()) {
                maxSpeed = item1;
            }
        }
        return maxSpeed;
    }

    private static ViewOfTransport getBestTransportByPrice(List<ViewOfTransport> transportsYouCanUse) {
        ViewOfTransport minPrice = transportsYouCanUse.get(0);
        for (ViewOfTransport item1 : transportsYouCanUse) {
            if (item1.getPricePerKm() <= minPrice.getPricePerKm()) {
                minPrice = item1;
            }
        }
        return minPrice;
    }
}
