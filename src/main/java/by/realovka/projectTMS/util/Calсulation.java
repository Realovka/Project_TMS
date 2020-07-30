package by.realovka.projectTMS.util;

public class Calсulation {
    private static final  int RADIUS=6371;
    private static final  double PI=3.1416;
    private static final  int CONST=180;

    public  static  double getDistance (double latitudeCityOut, double longitudeCityOut, double latitudeCityIn, double longitudeCityIn){
        double d=Math.sin(latitudeCityOut*PI/CONST)*Math.sin(latitudeCityIn*PI/CONST)+Math.cos(latitudeCityOut*PI/CONST)*Math.cos(latitudeCityIn*PI/CONST)
                *Math.cos(longitudeCityOut*PI/CONST-longitudeCityIn*PI/CONST);
        return Math.acos(d)*RADIUS;

    }

}
