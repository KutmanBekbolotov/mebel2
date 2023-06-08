package com.example.mebel2.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    int quantity;
    LocalDate localDate = LocalDate.now();
    @ManyToOne
    @JoinColumn(name = "worker_id")
    Worker worker;
    @ManyToOne
    @JoinColumn(name = "paper_id")
    Paper paper;







}
