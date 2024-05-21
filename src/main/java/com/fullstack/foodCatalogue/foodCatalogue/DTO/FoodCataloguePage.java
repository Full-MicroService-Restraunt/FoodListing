package com.fullstack.foodCatalogue.foodCatalogue.DTO;

import com.fullstack.foodCatalogue.foodCatalogue.Entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FoodCataloguePage {
    List<FoodItem> foodItemList;
    Restro restro;
}
