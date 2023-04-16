package com.example.mebel2.Services;

import com.example.mebel2.Dto.Input.WorkerDto;
import com.example.mebel2.Entities.Worker;
import com.example.mebel2.Repositories.WorkerRepository;
import com.example.mebel2.Services.Mappers.WorkerMapper;
import lombok.AllArgsConstructor;
import org.hibernate.jdbc.Work;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WorkerService implements WorkerMapper {
    WorkerRepository workerRepository;
    ModelMapper modelMapper;
    public List<Worker> findAll(){
        return workerRepository.findAll();
    }

    public Optional<Worker>findByUsername(String username){
        return workerRepository.findUserByUsername(username);
    }


    @Override
    public Worker toEntity(WorkerDto workerDto) {
        return modelMapper.map(workerDto, Worker.class);
    }

    @Override
    public WorkerDto toDto(Worker worker) {
        return modelMapper.map(worker, WorkerDto.class);
    }
}
