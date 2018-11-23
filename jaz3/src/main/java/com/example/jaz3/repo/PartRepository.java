package com.example.jaz3.repo;

import com.example.jaz3.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartRepository extends JpaRepository<Part,Long> {
    List<Part> findByCategory(String category);
    List<Part> findByName(String name);

}
