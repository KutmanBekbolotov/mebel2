package com.example.mebel2.Controllers;

import com.example.mebel2.Entities.Worker;
import com.example.mebel2.Services.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/open")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "*"})
public class WorkerController {
    WorkerService workerService;
    @GetMapping("/list")
    public List<Worker> workerList(){
        return workerService.findAll();
    }
}
