package com.fullstack.foodCatalogue.foodCatalogue.service;

import com.fullstack.foodCatalogue.foodCatalogue.DTO.FoodCataloguePage;
import com.fullstack.foodCatalogue.foodCatalogue.DTO.Restro;
import com.fullstack.foodCatalogue.foodCatalogue.Entity.FoodItem;
import com.fullstack.foodCatalogue.foodCatalogue.repository.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    FoodRepo foodRepo;

    @Autowired
    RestTemplate restTemplate;

    public FoodCataloguePage findByRestroId(int restroId){
        List<FoodItem> foodItemList = foodRepo.findByRestroId(restroId);
        Restro restro = getRestroDetails(restroId);
        return FoodCataloguePage.builder().foodItemList(foodItemList).restro(restro).build();
    }

    private Restro getRestroDetails(int restroId) {
        return restTemplate.getForObject("http://RestrauntListing/restraunt/"+restroId, Restro.class);
    }

    public FoodItem addFoodItem(FoodItem foodItem){
        return foodRepo.save(foodItem);
    }

    public List<FoodItem> getAllFoodItems(){
        return foodRepo.findAll();
    }

    public FoodItem getFoodById(int id){
        return foodRepo.findById(id).get();
    }
}
