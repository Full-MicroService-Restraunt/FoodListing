package com.fullstack.foodCatalogue.foodCatalogue.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Restro {
    private int id;
    private String name;
    private String address;
    private String city;
    private String Description;
}
