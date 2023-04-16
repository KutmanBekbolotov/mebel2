package com.example.mebel2.Services.Mappers;

import com.example.mebel2.Dto.Input.PaperDto;
import com.example.mebel2.Entities.Paper;

public interface PaperMapper {
    Paper toEntity(PaperDto paperDto);
    PaperDto toDto(Paper paper);
}
