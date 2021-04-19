package com.ecommerce.shoes.controller.admin;

import com.ecommerce.shoes.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/brands")
    public String getListBrand(Model model) {
//        model.addAttribute("brands", brandService.findAll());
        return "/admin/brand/list";
    }
}
