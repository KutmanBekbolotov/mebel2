package com.example.mebel2.Services;

import com.example.mebel2.Dto.Input.DetailDto;
import com.example.mebel2.Entities.Detail;
import com.example.mebel2.Entities.Paper;
import com.example.mebel2.Entities.Result;
import com.example.mebel2.Entities.Worker;
import com.example.mebel2.Exceptions.exceptions.PaperNotFoundException;
import com.example.mebel2.Repositories.DetailRepository;
import com.example.mebel2.Repositories.PaperRepository;
import com.example.mebel2.Repositories.ResultRepository;
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
    ResultRepository resultRepository;

    public Detail save(DetailDto detailDto ,Long result_id) {
        Optional<Result> optionalResult = resultRepository.findById(result_id);
        if(optionalResult.isEmpty()){
            throw new PaperNotFoundException("Нет такого листа!");
        }
        Detail detail = toEntity(detailDto);
        detail.setResult(optionalResult.get());
        return detailRepository.save(detail);
    }
    public String saved(List<DetailDto> detailList, Long result_id){
        detailList.forEach(detail -> {
            save(detail, result_id);
        });
        return "Saved all!";
    }
    public List<Detail> findDetailsByResult(Result result){
        return detailRepository.findDetailByResult(result);
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
