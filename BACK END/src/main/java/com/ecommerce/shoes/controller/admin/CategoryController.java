package com.ecommerce.shoes.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
    @GetMapping("/category")
    public String getListBrand() {
        return "/admin/category/list";
    }
}
