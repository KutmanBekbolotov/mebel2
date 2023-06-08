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
    @ManyToOne
    @JoinColumn(name = "result_id",nullable = true)
    Result result;

    public Model(int width, int height, LocalDate localDate) {
        this.width = width;
        this.height = height;
        this.localDate = localDate;
    }

}
