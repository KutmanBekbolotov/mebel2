package com.example.mebel2.Controllers;

import com.example.mebel2.Dto.Input.DetailDto;
import com.example.mebel2.Dto.OutPut.ResultDto;
import com.example.mebel2.Entities.Detail;
import com.example.mebel2.Entities.Paper;
import com.example.mebel2.Entities.Result;
import com.example.mebel2.Services.DetailService;
import com.example.mebel2.Services.PaperService;
import com.example.mebel2.Services.RegistrationService;
import com.example.mebel2.Services.ResultService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/open")
public class ResultController{
    ResultService resultService;
    RegistrationService registrationService;
    PaperService paperService;
    DetailService detailService;
    @PostMapping("/result/make/{paper_id}")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "*"})
    public Result resulter(@RequestBody List<DetailDto> detailList, @PathVariable Long paper_id){
         Result result   = resultService.count(detailList,paperService.findById(paper_id));
         resultService.save(result);
        detailService.saved(detailList, result.getId());
        return result;

    }

    @GetMapping("/result/list")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "*"})
    public List<Result> resultList(){
        return resultService.findAll();
    }

//    @GetMapping("/result/count/{paper_id}")
//    public Result result(@RequestBody List<DetailD> detailList, @PathVariable Long paper_id ){
//        Result result = new Result();
//        result.setPaper(paperService.findById(paper_id));
//        detailService.findDetailsByResult(result);
//        return result;
//    }




}
