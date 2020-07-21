//package by.controller;
//
//import by.util.DBConnection;
//import by.util.Message;
//import by.entity.City;
//import by.entity.ViewOfTransport;
//
//import java.util.List;
//
//public class BestTravelByPriceController implements BestTravelController {
//
//    City cityFirstOut = new City();
//    City cityFirstIn = new City();
//    ViewOfTransport viewOfTransport = new ViewOfTransport();
//    String cheap = "дешевый";
//
//    @Override
//    public void getBestTravel(String cityOut, String cityIn, int passengersOut, double cargoOut) {
//        List<City> cities = DBConnection.getListCities();
//        List<ViewOfTransport> transports = DBConnection.getListTransport();
//        for (City item : cities) {
//            for (City item2 : cities) {
//                for (ViewOfTransport item3 : transports) {
//                    cityFirstOut = item;
//                    cityFirstIn = item2;
//                    viewOfTransport = item3;
//                    if (item.getName().equals(cityOut) && item2.getName().equals(cityIn) && item3.getPassengers() >= passengersOut && item3.getCargo() >= cargoOut &&
//                            item.getContinent().equals(item2.getContinent())) {
//                        Message.getMessageAboutTravel(cityOut, cityIn, passengersOut, cargoOut, viewOfTransport, cityFirstOut, cityFirstIn, cheap);
//                        return;
//                    } else if(item.getName().equals(cityOut) && item2.getName().equals(cityIn) && item3.getPassengers() >= passengersOut && item3.getCargo() >= cargoOut &&
//                            !item.getContinent().equals(item2.getContinent()){
//
//                    }
//
//                }
//            }
//        }
//    }
//}
