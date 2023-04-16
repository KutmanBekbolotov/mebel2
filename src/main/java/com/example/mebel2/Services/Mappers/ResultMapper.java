package com.example.mebel2.Services.Mappers;

import com.example.mebel2.Dto.OutPut.ResultDto;
import com.example.mebel2.Entities.Result;
import org.springframework.web.bind.annotation.Mapping;


public interface ResultMapper {
    public Result toDto(ResultDto resultDto);
    public ResultDto toEntity(Result result);

}
