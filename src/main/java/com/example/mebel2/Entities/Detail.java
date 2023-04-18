package com.example.mebel2.Entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Data
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
    @JoinColumn(name = "paper_id",nullable = true)
    Paper paper;
    @ManyToOne
    @JoinColumn(name = "worker_id",nullable = true)
    Worker worker;


}
