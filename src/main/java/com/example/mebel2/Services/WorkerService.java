package com.example.mebel2.Services;

import com.example.mebel2.Entities.Worker;
import com.example.mebel2.Repositories.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkerService {
    WorkerRepository workerRepository;
    public List<Worker> findAll(){
        return workerRepository.findAll();
    }


}
