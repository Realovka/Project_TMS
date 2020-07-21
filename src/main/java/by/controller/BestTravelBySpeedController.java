//package by.controller;
//
//import by.util.DBConnection;
//import by.util.Message;
//import by.entity.City;
//import by.entity.ViewOfTransport;
//
//import java.util.List;
//
//public class BestTravelBySpeedController implements BestTravelController {
//
//    City cityFirstOut = new City();
//    City cityFirstIn = new City();
//    ViewOfTransport viewOfTransport = new ViewOfTransport();
//    String quickly="быстрый";
//
//    @Override
//    public void getBestTravel(String cityOut, String cityIn, int passengersOut, double cargoOut) {
//        List<City> cities = DBConnection.getListCities();
//        List<ViewOfTransport> transports = DBConnection.getListTransport();
//
//        for (City item : cities) {
//            for (City item2 : cities) {
//                if (item.getName().equals(cityOut) && item.isAirport() && item2.getName().equals(cityIn) && item2.isAirport()) {
//                    cityFirstOut = item;
//                    cityFirstIn = item2;
//                    for (int i = 0; i < transports.size() - 1; i++) {
//                        int maxSpeedByAir = transports.get(i).getSpeed();
//                        viewOfTransport = transports.get(0);
//                        if (transports.get(i + 1).getSpeed() > maxSpeedByAir && transports.get(i + 1).getPassengers() >= passengersOut &&
//                                transports.get(i + 1).getCargo() >= cargoOut) {          //вариант, когда путешествие на самолете
//                            maxSpeedByAir = transports.get(i + 1).getSpeed();
//                            viewOfTransport = transports.get(i + 1);
//                            Message.getMessageAboutTravel(cityOut, cityIn, passengersOut, cargoOut, viewOfTransport, cityFirstOut, cityFirstIn, quickly);
//                            return;
//                        } else if ((transports.get(i + 1).getSpeed() > maxSpeedByAir && transports.get(i + 1).getPassengers() >= passengersOut &&
//                                transports.get(i + 1).getCargo() < cargoOut) || (transports.get(i + 1).getSpeed() > maxSpeedByAir && transports.get(i + 1).getPassengers() < passengersOut &&
//                                transports.get(i + 1).getCargo() < cargoOut)) {               //вариант, когда груз слишком большой
//                            System.out.println("Такое количество груза нельзя перевезти ни на одном виде транспорта");
//                            return;
//                        } else if (transports.get(i + 1).getSpeed() > maxSpeedByAir && transports.get(i + 1).getPassengers() <= passengersOut &&
//                                transports.get(i + 1).getCargo() >= cargoOut) {          //вариант, когда груз большой, но его можно перевезти по морю
//                            for (City item3 : cities) {
//                                for (City item4 : cities) {
//                                    if (item3.getName().equals(cityOut) && item3.isSeaPort() && item4.getName().equals(cityIn) && item4.isSeaPort()) {
//                                        List<ViewOfTransport> seaTransports = DBConnection.getListSeaTransport();
//                                        for (i = 0; i < seaTransports.size() - 1; i++) {
//                                            int maxSpeedBySea = seaTransports.get(i).getSpeed();
//                                            if (seaTransports.get(i + 1).getSpeed() > maxSpeedBySea && seaTransports.get(i + 1).getPassengers() >= passengersOut &&
//                                                    seaTransports.get(i + 1).getCargo() >= cargoOut) {
//                                                maxSpeedBySea = seaTransports.get(i + 1).getSpeed();
//                                                viewOfTransport = seaTransports.get(i + 1);
//                                                for (ViewOfTransport item5 : seaTransports) {
//                                                    if (item5.getCargo() >= cargoOut) {
//                                                        Message.getMessageAboutTravel(cityOut, cityIn, passengersOut, cargoOut, viewOfTransport, cityFirstOut, cityFirstIn, quickly);
//                                                        return;
//                                                    }
//                                                    if (viewOfTransport.getPassengers() < passengersOut &&
//                                                            viewOfTransport.getCargo() >= cargoOut) {                   //вариант, когда кол-во чел-к слишком большое
//                                                        System.out.println("Такое количество человек нельзя перевезти ни на одном виде транспорта");
//                                                        return;
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//
//        for (City item7 : cities) {
//            for (City item8 : cities) {
//                cityFirstOut = item7;
//                cityFirstIn = item8;
//                if (item7.getName().equals(cityOut) && ((!item7.isAirport() && !item8.isAirport()) || (item7.isAirport() && !item8.isAirport()) || (!item7.isAirport() && item8.isAirport()))
//                        && item8.getName().equals(cityIn) && item7.getContinent().equals(item8.getContinent())) {
//                    List<ViewOfTransport> groundTransports = DBConnection.getListGroundTransport();
//                    for (int i = 0; i < groundTransports.size() - 1; i++) {
//                        int maxSpeedByGround = groundTransports.get(i).getSpeed();
//                        viewOfTransport = groundTransports.get(0);
//                        if (groundTransports.get(i + 1).getSpeed() > maxSpeedByGround && groundTransports.get(i + 1).getPassengers() >= passengersOut &&
//                                groundTransports.get(i + 1).getCargo() >= cargoOut) {
//                            maxSpeedByGround = groundTransports.get(i + 1).getSpeed();
//                            viewOfTransport = groundTransports.get(i + 1);
//                        } else if (viewOfTransport.getPassengers() < passengersOut || viewOfTransport.getCargo() < cargoOut) {
//                            System.out.println("Перевозка невозможна из-за превышения груза или кол-ва человек для возможного вида транспорта");
//                            return;
//                        }
//                        Message.getMessageAboutTravel(cityOut, cityIn, passengersOut, cargoOut, viewOfTransport, cityFirstOut, cityFirstIn, quickly);
//                        return;
//
//                    }
//                    if (item7.getName().equals(cityOut) && ((!item7.isAirport() && !item8.isAirport()) || (item7.isAirport() && !item8.isAirport()) || (!item7.isAirport() && item8.isAirport()))
//                            && item8.getName().equals(cityIn) && !item7.getContinent().equals(item8.getContinent())) {
//                        System.out.println("Переезд невозможен, так как города на разных материках, и как минимум в одном из них нет ни аэропорта, ни морского порта");
//                    }
//                }
//            }
//        }
//    }
//}
//

