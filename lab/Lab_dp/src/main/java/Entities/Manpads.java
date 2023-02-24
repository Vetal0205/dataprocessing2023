package Entities;

import java.io.Serializable;

public class Manpads implements Serializable {
    private int id;
    private String name;
    private double weight;
    private String photo;

    @Override
    public String toString() {
        return "Manpads{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", photo='" + photo + '\'' +
                '}';
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Manpads(int id, String name, double weight, String photo) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.photo = photo;
    }
    public Manpads(){}
}
