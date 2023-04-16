package com.example.mebel2.Services;

import com.example.mebel2.Dto.Input.DetailDto;
import com.example.mebel2.Dto.Input.ModelDto;
import com.example.mebel2.Dto.Input.PaperDto;
import com.example.mebel2.Dto.OutPut.ResultDto;
import com.example.mebel2.Entities.Result;
import com.example.mebel2.Repositories.ResultRepository;
import com.example.mebel2.Services.Mappers.ResultMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
@AllArgsConstructor
public class ResultService implements ResultMapper {
    ResultRepository resultRepository;
    ModelMapper modelMapper;
    public ResultDto calculate(PaperDto paperDto, DetailDto detailDto){
        System.out.println(paperDto.getHeight()*paperDto.getWidth());
        System.out.println(detailDto.getHeight()*detailDto.getWidth()+5);
        return new ResultDto(paperDto.getWidth()* paperDto.getHeight()/(detailDto.getWidth()*detailDto.getHeight()+5));

    }
    public Result save(Result result){
        return resultRepository.save(result);
    }



    public ResultDto calculate(int dWidth, int dHeight, int pWidth, int pHeight, int dQuantity){
        System.out.println(pHeight*pWidth);
        System.out.println((dHeight*dWidth+5)*dQuantity);
        return new ResultDto(pHeight*pWidth/((dHeight*dWidth+5)*dQuantity));

    }

    @Override
    public Result toDto(ResultDto resultDto) {
        return modelMapper.map(resultDto, Result.class);
    }

    @Override
    public ResultDto toEntity(Result result) {
        return modelMapper.map(result, ResultDto.class);
    }
}
