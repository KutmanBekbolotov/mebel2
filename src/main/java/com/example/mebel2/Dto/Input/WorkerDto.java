package com.example.mebel2.Dto.Input;

import com.example.mebel2.Enums.WORKER_ROLE;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class WorkerDto {
    @Size(message = "Name must be between 5 and 100 characters long", min = 5, max = 100)
    String name;
    @Size(message = "Name must be between 5 and 24 characters long", min = 5, max = 24)
    String username;
    @Size(message = "Name must be between 5 and 100 characters long", min = 5, max = 100)
    String password;
    @Enumerated(EnumType.STRING)
    WORKER_ROLE workerRole;


}
