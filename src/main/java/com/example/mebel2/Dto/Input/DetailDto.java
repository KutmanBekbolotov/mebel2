package com.example.mebel2.Dto.Input;

import lombok.Data;

import javax.validation.constraints.Positive;

@Data
public class DetailDto {
    @Positive(message = "Width must be greater than 0")
    int width;
    @Positive(message = "Height must be greater than 0")
    int height;
    @Positive(message = "Quantity must be greater than 0")
    int quantity;

}
