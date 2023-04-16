package com.example.mebel2.Services;

import com.example.mebel2.Entities.Model;
import com.example.mebel2.Repositories.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelService {
    ModelRepository modelRepository;

    public Page<Model> getSizeByPage(int number, int pageSize){
        PageRequest pageRequest = PageRequest.of(number,pageSize);
        return modelRepository.findAll(pageRequest);
    }
    public Model save(Model model){
        return modelRepository.save(model);
    }



}
