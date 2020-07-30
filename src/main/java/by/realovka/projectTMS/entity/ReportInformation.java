package by.realovka.projectTMS.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;


@XmlType(propOrder = {"id","cityNameOut","cityNameIn","passengers","cargo","fastTransport","cheapTransport"})
public class ReportInformation {

    private int id;
    private String cityNameOut;
    private String cityNameIn;
    private int passengers;
    private double cargo;
    private String fastTransport;
    private String cheapTransport;

    public ReportInformation(String cityNameOut, String cityNameIn, int passengers, double cargo, String fastTransport, String cheapTransport) {
        this.cityNameOut = cityNameOut;
        this.cityNameIn = cityNameIn;
        this.passengers = passengers;
        this.cargo = cargo;
        this.fastTransport = fastTransport;
        this.cheapTransport = cheapTransport;
    }

    public ReportInformation(int id, String cityNameOut, String cityNameIn, int passengers, double cargo, String fastTransport, String cheapTransport) {
        this.id = id;
        this.cityNameOut = cityNameOut;
        this.cityNameIn = cityNameIn;
        this.passengers = passengers;
        this.cargo = cargo;
        this.fastTransport = fastTransport;
        this.cheapTransport = cheapTransport;
    }

    public ReportInformation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityNameOut() {
        return cityNameOut;
    }

    public void setCityNameOut(String cityNameOut) {
        this.cityNameOut = cityNameOut;
    }

    public String getCityNameIn() {
        return cityNameIn;
    }

    public void setCityNameIn(String cityNameIn) {
        this.cityNameIn = cityNameIn;
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

    public String getFastTransport() {
        return fastTransport;
    }

    public void setFastTransport(String fastTransport) {
        this.fastTransport = fastTransport;
    }

    public String getCheapTransport() {
        return cheapTransport;
    }

    public void setCheapTransport(String cheapTransport) {
        this.cheapTransport = cheapTransport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportInformation that = (ReportInformation) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ReportInformation{" +
                "id=" + id +
                ", cityNameOut='" + cityNameOut + '\'' +
                ", cityNameIn='" + cityNameIn + '\'' +
                ", passengers=" + passengers +
                ", cargo=" + cargo +
                ", fastTransport='" + fastTransport + '\'' +
                ", cheapTransport='" + cheapTransport + '\'' +
                '}';
    }
}
