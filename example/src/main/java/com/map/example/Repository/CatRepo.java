package com.map.example.Repository;

import com.map.example.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepo extends JpaRepository<Category,Integer> {
}
