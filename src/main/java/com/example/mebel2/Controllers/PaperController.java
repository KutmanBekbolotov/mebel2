package com.example.mebel2.Controllers;

import com.example.mebel2.Entities.Paper;
import com.example.mebel2.Enums.FormatEnum;
import com.example.mebel2.Projections.PaperProjection;
import com.example.mebel2.Services.PaperService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/open")
public class PaperController {
    PaperService paperService;
    @GetMapping("/paper/all")
    public List<PaperProjection> findAll(){
        return paperService.findAllProjections();
    }
    @GetMapping("/paper/formats")
    public List<FormatEnum> formatEnums(){
        return List.of(FormatEnum.LPSD,FormatEnum.PDF, FormatEnum.PDFBIG,FormatEnum.Vacuum, FormatEnum.MDFRASPIL, FormatEnum.ErgerorList, FormatEnum.Table, FormatEnum.BigTable);
    }
    @PostMapping("/save/paper")
    public Paper saved(@RequestBody Paper paper){
        return paperService.save(paper);
    }


}
