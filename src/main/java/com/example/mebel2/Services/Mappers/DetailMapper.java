package com.example.mebel2.Services.Mappers;

import com.example.mebel2.Dto.Input.DetailDto;
import com.example.mebel2.Entities.Detail;

public interface DetailMapper {
    DetailDto toDto(Detail detail);
    Detail toEntity(DetailDto detailDto);
}
