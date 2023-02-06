package Entities;

import java.io.Serializable;

public class Manpads implements Serializable {
    private String name;
    private double weight;
    private String photo;

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

    public Manpads(String name, double weight, String photo) {
        this.name = name;
        this.weight = weight;
        this.photo = photo;
    }
}
