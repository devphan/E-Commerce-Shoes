package com.ecommerce.shoes.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductReq {
    private String name;

    private String image;

    private long price;

    private String description;

    private int brandId;

    private ArrayList<Integer> categoryIds;

}
