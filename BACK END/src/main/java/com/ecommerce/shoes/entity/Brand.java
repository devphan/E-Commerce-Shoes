package com.ecommerce.shoes.entity;

import com.sun.istack.NotNull;
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
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String thumbnail;

//    @OneToMany(mappedBy = "brand")
//    private List<Product> products;

    public Brand(String name, String thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }
}
