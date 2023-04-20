package com.example.mebel2.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_detail")
public class Detail {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    Long id;
    @Positive(message = "Width must be greater than 0")
    int width;
    @Positive(message = "Height must be greater than 0")
    int height;
    @Positive(message = "Quantity must be greater than 0")
    int quantity;
    String description;
    @ManyToOne
    @JoinColumn(name = "result_id")
    Result result;

    public Detail(int width, int height, int quantity) {
        this.width = width;
        this.height = height;
        this.quantity = quantity;
    }

    public Detail(int width, int height, int quantity, String description) {
        this.width = width;
        this.height = height;
        this.quantity = quantity;
        this.description = description;
    }
}
