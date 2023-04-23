package com.example.mebel2.Services;

import com.example.mebel2.Entities.Paper;
import com.example.mebel2.Exceptions.exceptions.PaperNotFoundException;
import com.example.mebel2.Projections.PaperProjection;
import com.example.mebel2.Repositories.PaperRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaperService {
    PaperRepository paperRepository;
    public List<PaperProjection>findAllProjections(){
        return paperRepository.findAllProjections();
    }
    public Paper save(Paper paper){
        return paperRepository.save(paper);
    }
    public Paper findById(Long id){
        Optional<Paper>optionalPaper = paperRepository.findById(id);
        if(optionalPaper.isEmpty()){
            throw new PaperNotFoundException("Такого листа не существует!");
        }
        return optionalPaper.get();

    }
    public List<Paper>findAll(){
        return paperRepository.findAll();
    }
}
