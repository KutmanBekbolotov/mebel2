package com.example.mebel2.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "tb_paper")
public class Paper {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    Long id;
    String name;
    int width;
    int height;
    public Paper(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }
}
