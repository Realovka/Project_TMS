package by.realovka.projectTMS.application;

import by.realovka.projectTMS.entity.TransportType;
import by.realovka.projectTMS.entity.TransportView;
import by.realovka.projectTMS.dao.DBConnectionDao;
import by.realovka.projectTMS.util.InPut;

import java.util.List;
import java.util.Scanner;

public class InsertOrUpdateTransportView {

    private static String transportName;
    private static boolean transportUpdate = true;
    private static boolean flag=true;
    private static   List<TransportType> typeOfTransports;

    public static TransportView setOrUpdate(int choice) {
        switch (choice) {
            case 4:
                insertViewOfTransport();
                break;
            case 6:
                updateViewOfTransport();
                break;
        }
        System.out.println("Введите скорость транспорта");
        Scanner speedScanner = new Scanner(System.in);
        int newSpeed = InPut.getInt(speedScanner);
        System.out.println("Введите количество пассажиров");
        Scanner passengersScanner = new Scanner(System.in);
        int newNumberOfPassengers = InPut.getInt(passengersScanner);
        System.out.println("Введите количество груза");
        Scanner cargoScanner = new Scanner(System.in);
        double newNumberOfCargo = InPut.getDouble(cargoScanner);
        TransportType typeOfTransport=getTypeOfTransport();
        System.out.println("Введите цену за км");
        Scanner pricePerKmScanner = new Scanner(System.in);
        double newPricePerKm = InPut.getDouble(pricePerKmScanner);
        return  new TransportView(transportName, newSpeed, newNumberOfPassengers, newNumberOfCargo, typeOfTransport, newPricePerKm);
    }

    public static String insertViewOfTransport() {
        System.out.println("Введите название транспорта");
        Scanner transportNameScanner = new Scanner(System.in);
        transportName = transportNameScanner.nextLine();
        return transportName;
    }

    public static String updateViewOfTransport() {
        List<String> viewOfTransports = DBConnectionDao.getViewOfTransport();
        while (transportUpdate) {
            System.out.println("Выберите из списка транспорт, который хотите редактировать");
            Scanner transportNameScanner = new Scanner(System.in);
            transportName = transportNameScanner.nextLine();
            transportUpdate = InPut.getViewOfTransport(viewOfTransports, transportName);
        }
        transportUpdate=true;
        return transportName;
    }

    public static TransportType getTypeOfTransport(){
        TransportType typeOfTransport=new TransportType();
        while (flag) {
            System.out.println("Выберите тип транспорта ");
            System.out.println(DBConnectionDao.getTypeOfTransport());
            Scanner transportNameScanner = new Scanner(System.in);
            String transportType = transportNameScanner.nextLine();
            typeOfTransports = DBConnectionDao.getTypeOfTransport();
            for (int i = 0; i < typeOfTransports.size(); i++) {
                if (typeOfTransports.get(i).getName().equals(transportType)) {
                    typeOfTransport=typeOfTransports.get(i);
                    flag=false;
                }
            } if (flag==true){
                System.out.println("Такого вида транспорта нет");
            }
        }
      return typeOfTransport;
    }
}
