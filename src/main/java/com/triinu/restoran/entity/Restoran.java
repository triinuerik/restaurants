package com.triinu.restoran.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "restoran")
public class Restoran {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    @Version
    private Integer version;
    @OneToMany(mappedBy = "restoran", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RestoRating> restoRatings;

    @Transient//Basically tells the database to ignore this
    private double averageRating = 0;


    @PostLoad
    private void onLoad() {
        Integer averageRating = 0;
        double counter = 0;
        for (RestoRating rating: getRestoRatings()) {
            averageRating+= rating.getRating();
            counter++;
        }
        if (counter != 0) {
            this.averageRating = (double) averageRating / counter;
        }


    }

    @Override
    public String toString() {
        return "Restoran{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", version=" + version +
                ", averageRating=" + averageRating +
                '}';
    }
}
