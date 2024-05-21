package com.fullstack.foodCatalogue.foodCatalogue.controller;

import com.fullstack.foodCatalogue.foodCatalogue.DTO.FoodCataloguePage;
import com.fullstack.foodCatalogue.foodCatalogue.Entity.FoodItem;
import com.fullstack.foodCatalogue.foodCatalogue.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
public class Endpoints {

    @Autowired
    FoodService foodService;

    @PostMapping("/add")
    public ResponseEntity<FoodItem> addFood(@RequestBody FoodItem foodItem){
        return new ResponseEntity<>(foodService.addFoodItem(foodItem), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> getFoodById(@PathVariable int id){
        return new ResponseEntity<>(foodService.getFoodById(id), HttpStatus.OK);
    }

    @GetMapping("/restro/{restroId}")
    public ResponseEntity<FoodCataloguePage> getFoodByRestroId(@PathVariable int restroId){
        return new ResponseEntity<>(foodService.findByRestroId(restroId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FoodItem>> getAllFoodItems(){
        return new ResponseEntity<>(foodService.getAllFoodItems(), HttpStatus.OK);
    }
}
