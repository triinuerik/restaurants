package com.triinu.restoran.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rating")
public class RestoRating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String comment;
    private Integer rating;
    @ManyToOne(optional = false)
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

    @Override
    public String toString() {
        return "RestoRating{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", rating=" + rating +
                ", restoran=" + restoran +
                '}';
    }
}
