package com.example.mebel.MebelTestJava;

import com.example.mebel2.Entities.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ResultTest {

    @Test
    //Cheking local date

    public void testDefaultLocalDate() {

        Result result = new Result();
        Assertions.assertEquals(LocalDate.now(), result.getLocalDate());
    }

    @Test
    //checking getters & setters
    
    public void testSetAndGetQuantity() {

        Result result = new Result();
        int expectedQuantity = 10;
        result.setQuantity(expectedQuantity);
        Assertions.assertEquals(expectedQuantity, result.getQuantity());
    }
}
