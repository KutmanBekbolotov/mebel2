package com.example.mebel2.Services;

import com.example.mebel2.Dto.Input.DetailDto;
import com.example.mebel2.Entities.Detail;
import com.example.mebel2.Entities.Paper;
import com.example.mebel2.Exceptions.exceptions.PaperNotFoundException;
import com.example.mebel2.Repositories.DetailRepository;
import com.example.mebel2.Repositories.PaperRepository;
import com.example.mebel2.Services.Mappers.DetailMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springdoc.core.converters.models.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DetailService implements DetailMapper {
    DetailRepository detailRepository;
    ModelMapper modelMapper;
    PaperRepository paperRepository;

    public Detail save(Detail detail ,Long paper_id) {
        Optional<Paper> optionalPaper = paperRepository.findById(paper_id);
        if(optionalPaper.isEmpty()){
            throw new PaperNotFoundException("Нет такого листа!");
        }
        return detailRepository.save(detail);
    }
    public String saved(List<Detail> detailList, Long paper_id){
        detailList.forEach(detail -> {
            save(detail, paper_id);
        });
        return "Saved all!";
    }
    public List<Detail> findDetailsByPaper(Paper paper){
        return detailRepository.findDetailByPaper(paper);
    }

    public List<Detail> findAll(){
        return detailRepository.findAll();
    }

    @Override
    public DetailDto toDto(Detail detail) {
        return modelMapper.map(detail, DetailDto.class) ;
    }

    @Override
    public Detail toEntity(DetailDto detailDto) {
        return modelMapper.map(detailDto, Detail.class);
    }
}
