package com.example.mebel2.Controllers;

import com.example.mebel2.Dto.Input.DetailDto;
import com.example.mebel2.Entities.Detail;
import com.example.mebel2.Services.DetailService;
import com.example.mebel2.Services.PaperService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/open")
public class DetailController {
    DetailService detailService;
    PaperService paperService;
    @PostMapping("/detail/save/{paper_id}")
    public DetailDto save(@RequestBody Detail detail, @PathVariable Long paper_id){
        return detailService.toDto( detailService.save(detail,paper_id));
    }
    @PostMapping("/detail/list/{paper_id}")
    public String saveList(List<Detail> detailList, @PathVariable Long paper_id){
        return detailService.saved(detailList, paper_id);
    }
    @GetMapping("/detail/list/{paper_id}")
    public List<Detail> detailList(@PathVariable Long paper_id){
        return detailService.findDetailsByPaper(paperService.findById(paper_id));
    }
    @GetMapping("/detail/all")
    public List<Detail>findAll(){
        return detailService.findAll();
    }




}
