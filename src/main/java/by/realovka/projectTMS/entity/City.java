package by.realovka.projectTMS.entity;

import java.util.Objects;

public class City {
    private int id;
    private String name;
    private double latitude;
    private double longitude;
    private boolean airport;
    private boolean seaPort;
    private String continent;

    public City(String name, double latitude, double longitude, boolean airport, boolean seaPort, String continent) {

        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.airport = airport;
        this.seaPort = seaPort;
        this.continent = continent;
    }

    public City(int id, String name, double latitude, double longitude, boolean airport, boolean seaPort, String continent) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.airport = airport;
        this.seaPort = seaPort;
        this.continent = continent;
    }

    public City() {
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isAirport() {
        return airport;
    }

    public void setAirport(boolean airport) {
        this.airport = airport;
    }

    public boolean isSeaPort() {
        return seaPort;
    }

    public void setSeaPort(boolean seaPort) {
        this.seaPort = seaPort;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", airport=" + airport +
                ", seaPort=" + seaPort +
                ", continent='" + continent + '\'' +
                '}';
    }
}
