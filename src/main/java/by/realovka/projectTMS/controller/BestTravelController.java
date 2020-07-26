package by.realovka.projectTMS.controller;

import by.realovka.projectTMS.entity.TransportView;
import by.realovka.projectTMS.dao.DBConnectionDao;
import by.realovka.projectTMS.entity.City;
import by.realovka.projectTMS.util.Message;

import java.util.ArrayList;
import java.util.List;



public class BestTravelController {
    private static final String SORTBYSPEED="быстрый";
    private static final String SORTBYPRICE="дешевый";
    private static TransportView minPrice =new TransportView();


    public static void getBestTransport(String cityOut, String cityIn, int passengersOut, double cargoOut) {

        City cityFirstOut = DBConnectionDao.getCityOut(cityOut);
        City cityFirstIn = DBConnectionDao.getCityOut(cityIn);
        List<TransportView> viewOfTransportList = getAllTransportFromTwoCities(cityFirstOut, cityFirstIn, passengersOut, cargoOut);

            if (viewOfTransportList == null) {
                System.out.println("Путешествие невозможно, так как города на разных континентах, и как минимум в одном из них нет ни аэропорта, ни морского порта");
                return;
            }


            TransportView transportBySpeed = BestTravelController.getBestTransportBySpeed(viewOfTransportList);
            if (transportBySpeed.getName() == null) {
                System.out.println("Путешествие невозможно, так как такое количество груза и(или) количество пассажиров невозможно перевезти ни на одном виде транспорта");
                return;
            }
            Message.getMessageAboutTravel(SORTBYSPEED, cityOut, cityIn, passengersOut, cargoOut, transportBySpeed, cityFirstOut, cityFirstIn);


            TransportView transportByPrice = BestTravelController.getBestTransportByPrice(viewOfTransportList);
            if (transportByPrice.getName() == null) {
                System.out.println("Путешествие невозможно, так как такое количество груза и(или) количество пассажиров невозможно перевезти ни на одном виде транспорта");
                return;
            }
            Message.getMessageAboutTravel(SORTBYPRICE, cityOut, cityIn, passengersOut, cargoOut, BestTravelController.getBestTransportByPrice(viewOfTransportList), cityFirstOut, cityFirstIn);


    }

   public   static List<TransportView> getAllTransportFromTwoCities(City cityFirstOut, City cityFirstIn, int passengersOut, double cargoOut) {
        List<TransportView> differentTransports = new ArrayList<>();
        List<TransportView> transportsYouCanUse = new ArrayList<>();
        if (cityFirstOut.isAirport() && cityFirstIn.isAirport()) {
            differentTransports.addAll(DBConnectionDao.getAllAirTransport());
        }
        if (cityFirstOut.isSeaPort() && cityFirstIn.isSeaPort()) {
            differentTransports.addAll(DBConnectionDao.getAllSeaTransport());
        }
        if (cityFirstOut.getContinent().equals(cityFirstIn.getContinent())) {
            differentTransports.addAll(DBConnectionDao.getAllGroundTransport());
        }

        if (differentTransports.size()==0){
            return new ArrayList<>();
        }

        for (TransportView item : differentTransports) {
            if (item.getPassengers() >= passengersOut && item.getCargo() >= cargoOut) {
                transportsYouCanUse.add(item);
            }
        }

        return transportsYouCanUse;
    }


    public static TransportView getBestTransportBySpeed(List<TransportView> transportsYouCanUse) {
        TransportView maxSpeed = new TransportView();

            for (TransportView item1 : transportsYouCanUse) {
                if (item1.getSpeed() > maxSpeed.getSpeed()) {
                    maxSpeed = item1;
                }
            }

        return maxSpeed;
    }

   public   static TransportView getBestTransportByPrice(List<TransportView> transportsYouCanUse) {

               minPrice = transportsYouCanUse.get(0);
               for (TransportView item1 : transportsYouCanUse) {
                   if (item1.getPricePerKm() <= minPrice.getPricePerKm()) {
                       minPrice = item1;
                   }
               }

        return minPrice;
    }
}
