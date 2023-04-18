package com.example.mebel2.Entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    int quantity;
    LocalDate localDate = LocalDate.now();




}
