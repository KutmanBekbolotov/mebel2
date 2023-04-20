package com.example.mebel.MebelTestJava;

import com.example.mebel2.Entities.Worker;
import com.example.mebel2.Enums.WORKER_ROLE;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkerTest {

    //testing object's contructor and getter
    @Test

    public void testConstructorAndGetters() {

        Long expectedId = 1L;
        String expectedUsername = "username";
        String expectedPassword = "password";
        WORKER_ROLE expectedRole = WORKER_ROLE.ROLE_ADMIN;

        Worker worker = new Worker();
        worker.setId(expectedId);
        worker.setUsername(expectedUsername);
        worker.setPassword(expectedPassword);
        worker.setRole(expectedRole);

        assertEquals(expectedId, worker.getId());
        assertEquals(expectedUsername, worker.getUsername());
        assertEquals(expectedPassword, worker.getPassword());
        assertEquals(expectedRole, worker.getRole());
    }

    //testing that to string works correct
    @Test

    public void testToString() {

        Worker worker = new Worker();
        worker.setId(1L);
        worker.setUsername("username");
        worker.setPassword("password");
        worker.setRole(WORKER_ROLE.ROLE_ADMIN);

        String expectedString = "Worker(id=1, username=username, password=password, role=ROLE_ADMIN)";

        assertEquals(expectedString, worker.toString());
    }
}
