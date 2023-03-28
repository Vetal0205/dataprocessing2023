package dp2023.lab7.Entities;

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
}
