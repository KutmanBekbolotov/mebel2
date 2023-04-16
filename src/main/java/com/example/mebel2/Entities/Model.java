package com.example.mebel2.Entities;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    int width;
    int height;
    int quantity;
    @Column(name = "description",columnDefinition = "TEXT")
    String description;
    String name;
    LocalDate localDate;

    public Model(int width, int height, LocalDate localDate) {
        this.width = width;
        this.height = height;
        this.localDate = localDate;
    }

}
