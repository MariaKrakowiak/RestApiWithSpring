package com.example.mywebapp.bike;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter@Setter
@Entity
@Table(name = "bikes")
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
 /*   @Column(nullable = false)*/
    private double number;
    @Column(nullable=false)
    private String color;
    @Column(nullable=false)
    private double weight;
    @Column(nullable=false)
    private String size;


    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", number=" + number +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", size='" + size + '\'' +
                '}';
    }
}

