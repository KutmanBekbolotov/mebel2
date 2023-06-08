package com.example.mebel2.Controllers;

import com.example.mebel2.Dto.Input.WorkerDto;
import com.example.mebel2.Entities.Worker;
import com.example.mebel2.Services.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/open")

public class WorkerController {
    WorkerService workerService;
    @GetMapping("/worker/list")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001","http://46.8.43.42:3000" ,"*"})
    public List<Worker> workerList(){
        return workerService.findAll();
    }
    @GetMapping("/worker/{id}")
    public WorkerDto findById(@PathVariable Long id){
        return workerService.findById(id);
 }
}
