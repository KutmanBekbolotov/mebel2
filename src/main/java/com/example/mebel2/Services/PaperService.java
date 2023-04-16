package com.example.mebel2.Services;

import com.example.mebel2.Entities.Paper;
import com.example.mebel2.Projections.PaperProjection;
import com.example.mebel2.Repositories.PaperRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
