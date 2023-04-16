package com.example.mebel2.Controllers;

import com.example.mebel2.Dto.OutPut.ResultDto;
import com.example.mebel2.Services.ResultService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/open")
public class ResultController{
    ResultService resultService;
    @GetMapping("/result/detail")
    public ResultDto resultByDetail(@RequestParam int dWidth,@RequestParam int dHeight, @RequestParam int pWidth, @RequestParam int pHeight, @RequestParam int quantity){
        return resultService.calculate(dWidth,dHeight,pWidth,pHeight, quantity);
    }
    @GetMapping("/result/model")
    public ResultDto resultByModel(){
//        return resultService.getClass();
        return null;
    }




}
