package com.example.mebel2.Services.Mappers;

import com.example.mebel2.Dto.Input.WorkerDto;
import com.example.mebel2.Entities.Worker;

public interface WorkerMapper {
    Worker toEntity(WorkerDto workerDto);
    WorkerDto toDto(Worker worker);
}
