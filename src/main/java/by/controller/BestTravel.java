package by.controller;

import by.entity.TypeOfTransport;
import by.entity.ViewOfTransport;
import by.util.DBConnection;
import by.entity.City;
import by.util.Message;

import java.util.ArrayList;
import java.util.List;


public class BestTravel {
    public static void getBestTransportBySpeed(String cityOut, String cityIn, int passengersOut, double cargoOut) {
        City cityFirstOut = DBConnection.getCityOut(cityOut);
        City cityFirstIn = DBConnection.getCityIn(cityIn);
        ViewOfTransport viewOfTransport= DBConnection.getTransport(passengersOut,cargoOut,  getAllTransportFromTwoCities(cityFirstOut,cityFirstIn));
        Message.getMessageAboutTravel(cityOut, cityIn,  passengersOut,  cargoOut,  viewOfTransport,  cityFirstOut, cityFirstIn);

    }

    private static List<TypeOfTransport> getAllTransportFromTwoCities(City cityFirstOut,City cityFirstIn){
        List<TypeOfTransport> typeOfTransports=new ArrayList<>();
        if(cityFirstOut.isAirport() && cityFirstIn.isAirport()){
            TypeOfTransport typeOfTransportAir=new TypeOfTransport(2);
            typeOfTransports.add(typeOfTransportAir);
        }
        if(cityFirstOut.isSeaPort() && cityFirstIn.isSeaPort()){
            TypeOfTransport typeOfTransportSea=new TypeOfTransport(3);
            typeOfTransports.add(typeOfTransportSea);
        }
        if(cityFirstOut.getContinent().equals(cityFirstIn.getContinent())){
            TypeOfTransport typeOfTransportGround=new TypeOfTransport(1);
            typeOfTransports.add(typeOfTransportGround);
        }
        return typeOfTransports;
    }

}
