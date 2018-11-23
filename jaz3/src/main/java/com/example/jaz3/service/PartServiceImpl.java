package com.example.jaz3.service;

import com.example.jaz3.model.Part;
import com.example.jaz3.repo.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PartServiceImpl implements PartService {

    @Autowired
    private PartRepository partRepository;

    public void setPartRepository(PartRepository partRepository){
        this.partRepository = partRepository;
    }
    @Override
    public List<Part> retrieveParts() {
        List<Part> parts = partRepository.findAll();
        return parts;
    }

    @Override
    public List<Part> findByCategory(String category) {
        List<Part> findByCategory = partRepository.findByCategory(category);
        return findByCategory;
    }

    @Override
    public List<Part> findByName(String name) {
        List<Part> findByName = partRepository.findByName(name);
        return findByName;
    }

    @Override
    public List<Part> asd(int min, int max ) {
        List<Part> parts = partRepository.findAll();
        List<Part> findByPrice = new ArrayList<>();
        for(Part p:parts)
        {
            if(p.getPrice()>=min && p.getPrice()<=max ){
              findByPrice.add(p);
            }
        }
        return findByPrice;
    }

    @Override
    public Part getPart(Long partId) {
        Optional<Part> optionalPart = partRepository.findById(partId);
        return optionalPart.get();
    }

    @Override
    public void savePart(Part part) {
    partRepository.save(part);
    }

    @Override
    public void deletePart(Long partId) {
    partRepository.deleteById(partId);
    }

    @Override
    public void updatePart(Part part) {
    partRepository.save(part);
    }
}
