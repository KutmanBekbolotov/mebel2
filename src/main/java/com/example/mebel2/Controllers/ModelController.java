package com.example.mebel2.Controllers;

import com.example.mebel2.Entities.Model;
import com.example.mebel2.Services.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/open")
public class ModelController {
   ModelService modelService;
    @GetMapping("/all")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001","http://46.8.43.42:3000" ,"*"})
    public Page<Model> sizePage(@RequestParam(defaultValue = "0") int width, @RequestParam(defaultValue = "10") int height ){
        return modelService.getSizeByPage(width,height);
    }
    @PostMapping("/save/size")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001","http://46.8.43.42:3000" ,"*"})
    public Model saved(@RequestParam int width, @RequestParam int height, @RequestParam int quantity){
       Model model = new Model();
        model.setWidth(width);
       model.setHeight(height);
       model.setQuantity(quantity);
        return modelService.save(model);
    }




}
