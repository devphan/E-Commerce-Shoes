package com.ecommerce.shoes.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class MenuController {
    @GetMapping("")
    public String getDashBoard() {
        return "/dashboard";
    }
    @GetMapping("/category")
    public String getListCategoy() {
        return "/admin/category/list";
    }

    @GetMapping("/brands")
    public String getListBrand() {
        return "/admin/brand/list";
    }

}
