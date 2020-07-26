package by.realovka.projectTMS.entity;

public class TransportType {
    private int id;
    private String name;


    public TransportType() {
    }

    public TransportType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TransportType(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return name + " ";
    }
}
