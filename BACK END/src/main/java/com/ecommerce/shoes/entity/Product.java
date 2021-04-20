package com.ecommerce.shoes.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String image;

    @Column
    private long price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "int(10) default 0")
    private int discount;

    @Column(columnDefinition = "int default 0")
    private int totalSold;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToMany
    @JoinTable(
            name = "product_category",
            //Khóa chính của class hiện tại
            joinColumns = @JoinColumn (name = "product_id"),

            //Khóa chính của bảng kia
            inverseJoinColumns = @JoinColumn(name = "category_id") //Khóa chính của bảng kia
    )
    private List<Category> categories; //Sẽ nằm trong mappedBy = "";



//    @PreRemove
//    private void removeCategories() {
//        this.categories.clear();
//    }

}
