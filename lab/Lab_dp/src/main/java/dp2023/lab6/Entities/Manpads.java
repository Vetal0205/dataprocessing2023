package dp2023.lab6.Entities;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "Manpads", schema = "vitalii")
public class Manpads implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double weight;
    private String photo;



    /*public Manpads(int id, String name, double weight, String photo) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.photo = photo;
    }
    public Manpads(){}*/
}
