package by.util;

import java.util.List;
import java.util.Scanner;

public class InPut {

    public static boolean getCity(List<String> cities, String city) {
        if(!cities.contains(city)){
            System.out.println("В списке нет такого города");
        }
        return !cities.contains(city);
    }

    public static int getInt(Scanner scanner){
        if(scanner.hasNextInt()){
            int a=scanner.nextInt();
            scanner.nextLine();
            return  a;
        }
        System.out.println(scanner.nextLine()+" -это не целое число. Повторите ввод.");
        return getInt(scanner);
    }

    public static double getDouble(Scanner scanner){
        if(scanner.hasNextDouble()){
            double a=scanner.nextDouble();
            scanner.nextLine();
            return  a;
        }
        System.out.println(scanner.nextLine()+" -это не дробное число. Повторите ввод.");
        return getDouble(scanner);
    }

}
