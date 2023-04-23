package com.example.mebel2.Controllers;

import com.example.mebel2.Dto.Input.DetailDto;
import com.example.mebel2.Entities.Detail;
import com.example.mebel2.Services.DetailService;
import com.example.mebel2.Services.PaperService;
import com.example.mebel2.Services.ResultService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/open")
public class DetailController {
    DetailService detailService;
    PaperService paperService;
    ResultService resultService;
    @PostMapping("/detail/save/{result_id}")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001","http://46.8.43.42:3000" ,"*"})
    public DetailDto save(@RequestBody DetailDto detail, @PathVariable Long result_id){
        return detailService.toDto( detailService.save(detail,result_id));
    }
    @PostMapping("/detail/save/list/{result_id}")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001","http://46.8.43.42:3000" ,"*"})
    public String saveList(List<DetailDto> detailList, @PathVariable Long result_id){
        return detailService.saved(detailList, result_id);
    }
    @GetMapping("/detail/list/{result_id}")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001","http://46.8.43.42:3000" ,"*"})
    public List<Detail> detailList(@PathVariable Long result_id){
        return detailService.findDetailsByResult(resultService.findById(result_id));
    }
    @GetMapping("/detail/all")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001","http://46.8.43.42:3000" ,"*"})
    public List<Detail>findAll(){
        return detailService.findAll();
    }




}
