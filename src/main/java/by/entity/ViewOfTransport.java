package by.entity;

import by.entity.TypeOfTransport;

public class ViewOfTransport {
    private  int id;
    private String name;
    private int speed;
    private int passengers;
    private double cargo;
    private TypeOfTransport typeOfTransport;
    private double pricePerKm;

    public ViewOfTransport(int id, String name, int speed, int passengers, double cargo,  double pricePerKm) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.passengers = passengers;
        this.cargo = cargo;
        this.pricePerKm = pricePerKm;
    }

    public ViewOfTransport(int id, String name, int speed, int passengers, double cargo, TypeOfTransport typeOfTransport, double pricePerKm) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.passengers = passengers;
        this.cargo = cargo;
        this.typeOfTransport = typeOfTransport;
        this.pricePerKm = pricePerKm;
    }

    public ViewOfTransport() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public double getCargo() {
        return cargo;
    }

    public void setCargo(double cargo) {
        this.cargo = cargo;
    }

    public TypeOfTransport getTypeOfTransport() {
        return typeOfTransport;
    }

    public void setTypeOfTransport(TypeOfTransport typeOfTransport) {
        this.typeOfTransport = typeOfTransport;
    }

    public double getPricePerKm() {
        return pricePerKm;
    }

    public void setPricePerKm(double pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    @Override
    public String toString() {
        return "ViewOfTransport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                ", passengers=" + passengers +
                ", cargo=" + cargo +
                ", typeOfTransport=" + typeOfTransport +
                ", pricePerKm=" + pricePerKm +
                '}';
    }
}
