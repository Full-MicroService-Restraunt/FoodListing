package com.fullstack.foodCatalogue.foodCatalogue.repository;

import com.fullstack.foodCatalogue.foodCatalogue.Entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepo extends JpaRepository<FoodItem, Integer> {
    public List<FoodItem> findByRestroId(int restroId);
}
