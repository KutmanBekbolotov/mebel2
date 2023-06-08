package com.example.mebel2.Services;

import com.example.mebel2.Dto.Input.DetailDto;
import com.example.mebel2.Dto.Input.PaperDto;
import com.example.mebel2.Dto.OutPut.ResultDto;
import com.example.mebel2.Entities.Detail;
import com.example.mebel2.Entities.Paper;
import com.example.mebel2.Entities.Result;
import com.example.mebel2.Exceptions.exceptions.ResultException;
import com.example.mebel2.Repositories.ResultRepository;
import com.example.mebel2.Services.Mappers.ResultMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@AllArgsConstructor
public class ResultService implements ResultMapper {
    ResultRepository resultRepository;
    ModelMapper modelMapper;
    RegistrationService registrationService;
    public ResultDto calculate(PaperDto paperDto, DetailDto detailDto){
        System.out.println(paperDto.getHeight()*paperDto.getWidth());
        System.out.println(detailDto.getHeight()*detailDto.getWidth()+5);
        return new ResultDto(paperDto.getWidth()* paperDto.getHeight()/(detailDto.getWidth()*detailDto.getHeight()+5));

    }


    public Result save(Result result){
        return resultRepository.save(result);
    }
    public Result findById(Long id){
        Optional<Result> optionalResult = resultRepository.findById(id);
        if(optionalResult.isEmpty()){
            throw new ResultException("Такого результата нет!");
        }
        return optionalResult.get();
    }

    public ResultDto calculate(int dWidth, int dHeight, int pWidth, int pHeight, int dQuantity){
        System.out.println(pHeight*pWidth);
        System.out.println((dHeight*dWidth+5)*dQuantity);
        return new ResultDto(pHeight*pWidth/((dHeight*dWidth+5)*dQuantity));
    }
    public Result count(List<DetailDto> detailList, Paper paper){
       double totalArea = 0;
        for (DetailDto detail: detailList) {
            totalArea += ((detail.getHeight() * detail.getWidth() + 5)*detail.getQuantity());
        }
        Result result = new Result();
        result.setPaper(paper);
        result.setWorker(registrationService.currentUser());
        double operation = totalArea / (paper.getHeight()* paper.getWidth());
        System.out.println(totalArea + " total Area");
        System.out.println("Paper area is "+ paper.getHeight()* paper.getWidth());
        System.out.println(operation + " Operations");
        if(operation > 0){
            result.setQuantity((int)Math.ceil(operation));
        }
        else{
            result.setQuantity(1);
        }
        return result;
    }
    public List<Result>findAll(){
        return resultRepository.findAll();
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
