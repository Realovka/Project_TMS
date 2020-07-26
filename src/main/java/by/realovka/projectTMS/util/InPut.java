package by.realovka.projectTMS.util;

import java.util.*;

public class InPut {
    private static Scanner scanner = new Scanner(System.in);

    public static boolean getCity(List<String> cities, String city) {

        if (!cities.contains(city)) {
            System.out.println("В списке нет такого города");
        }
        return !cities.contains(city);
    }

    public static boolean getViewOfTransport(List<String> view_of_transports, String transport) {

        if (!view_of_transports.contains(transport)) {
            System.out.println("В списке нет такого транспорта");
        }
        return !view_of_transports.contains(transport);
    }

    public static int getInt(Scanner scanner) {
        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            scanner.nextLine();
            return a;
        }
        System.out.println(scanner.nextLine() + " -это не целое число. Повторите ввод.");
        return getInt(scanner);
    }

    public static double getDouble(Scanner scanner) {
        if (scanner.hasNextDouble()) {
            double a = scanner.nextDouble();
            scanner.nextLine();
            return a;
        }
        System.out.println(scanner.nextLine() + " -это не дробное число. Повторите ввод.");
        return getDouble(scanner);
    }

    public static List<Boolean> getBooleanCollection (Scanner scanner) {
        String line=scanner.nextLine();
        List<Boolean> list=new ArrayList<>();
        Boolean airportOrSeaPort = false;
        Boolean flag=true;
        if (line.equalsIgnoreCase("да")) {
            airportOrSeaPort = true;
            flag=false;
            list= Arrays.asList(flag,airportOrSeaPort);
        } else if (line.equalsIgnoreCase("нет")) {
            airportOrSeaPort = false;
            flag=false;
            list= Arrays.asList(flag,airportOrSeaPort);
        } else {
            System.out.println("Так нельзя ответить на этот вопрос. Повторите ввод");
            list= Arrays.asList(flag,airportOrSeaPort);
        }
        return list;
    }

    public static boolean getContinent(String continent,List<String> list){
        if (list.contains(continent)) {
           return false;
        } else {
            System.out.println("Вы неправильно ввели континент. Повторите ввод");
            return true;
        }

    }

}
