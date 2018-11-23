package com.example.jaz3.controller;


import com.example.jaz3.model.Part;
import com.example.jaz3.service.PartService;
import com.example.jaz3.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PartRestController {

    @Autowired
    private PartServiceImpl partService;

    public void setPartService(PartServiceImpl partService){
        this.partService = partService;
    }
    @GetMapping("/api/parts")
    public List<Part> getParts() {
        List<Part> parts = partService.retrieveParts();
        return parts;
    }
    @GetMapping("/api/parts/category/{category}")
    public List<Part> findByCategory(@PathVariable String category) {
        List<Part> parts = partService.findByCategory(category);
        return parts;
    }
    @GetMapping("/api/parts/name/{name}")
    public List<Part> findByName(@PathVariable String name) {
        List<Part> parts = partService.findByName(name);
        return parts;
    }
    @GetMapping("/api/parts/price/{min}/{max}")
    public List<Part> asd(@PathVariable int min,@PathVariable int max) {
        List<Part> parts = partService.asd(min,max);
        return parts;
    }

    @GetMapping("/api/parts/{partId}")
    public Part getPart(@PathVariable(name="partId")Long partId){
        return partService.getPart(partId);
    }

    @PostMapping("/api/parts")
    public void savePart(Part part){
        partService.savePart(part);
        System.out.println("Czesc dodana pomyslnie");
    }

    @DeleteMapping("/api/parts/{partId}")
    public void deletePart(@PathVariable(name="partId")Long partId){
        partService.deletePart(partId);
        System.out.println("Czesc usunieta pomyslnie");
    }

    @PutMapping("/api/parts/{partId}")
    public void updatePart(@RequestBody Part part,@PathVariable(name="partId")Long partId){
        Part prt = partService.getPart(partId);
        if(prt != null){
            partService.updatePart(part);
        }
    }

}
