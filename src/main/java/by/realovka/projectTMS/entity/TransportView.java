package by.realovka.projectTMS.entity;

import java.util.Objects;

public class TransportView {
    private  int id;
    private String name;
    private int speed;
    private int passengers;
    private double cargo;
    private TransportType typeOfTransport;
    private double pricePerKm;



    public TransportView(String name, int speed, int passengers, double cargo, TransportType typeOfTransport, double pricePerKm) {
        this.name = name;
        this.speed = speed;
        this.passengers = passengers;
        this.cargo = cargo;
        this.typeOfTransport = typeOfTransport;
        this.pricePerKm = pricePerKm;
    }

    public TransportView(int id, String name, int speed, int passengers, double cargo, TransportType typeOfTransport, double pricePerKm) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.passengers = passengers;
        this.cargo = cargo;
        this.typeOfTransport = typeOfTransport;
        this.pricePerKm = pricePerKm;
    }

    public TransportView() {
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

    public TransportType getTypeOfTransport() {
        return typeOfTransport;
    }

    public void setTypeOfTransport(TransportType typeOfTransport) {
        this.typeOfTransport = typeOfTransport;
    }

    public double getPricePerKm() {
        return pricePerKm;
    }

    public void setPricePerKm(double pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportView that = (TransportView) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
