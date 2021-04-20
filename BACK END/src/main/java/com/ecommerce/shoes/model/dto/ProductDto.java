package com.ecommerce.shoes.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int id;

    private String name;

    private String image;

    private String description;

    private String brand;

    private ArrayList<String> categories;

    private long price;

    private int totalSold;


}
