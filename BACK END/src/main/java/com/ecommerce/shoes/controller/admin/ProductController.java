package com.ecommerce.shoes.controller.admin;

import com.ecommerce.shoes.entity.Brand;
import com.ecommerce.shoes.entity.Product;
import com.ecommerce.shoes.model.request.CreateProductReq;
import com.ecommerce.shoes.service.BrandService;
import com.ecommerce.shoes.service.CategoryService;
import com.ecommerce.shoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;


    //Get from create
    @GetMapping("/admin/products/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new CreateProductReq());

        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("categories", categoryService.findAll());

        return "/admin/product/create";
    }

    @PostMapping("/admin/products/create")
    public String saveProduct(@ModelAttribute("product") CreateProductReq req, Model model) {
        productService.createProduct(req);
        model.addAttribute("product", new CreateProductReq());
        return "/admin/product/create";
    }



}
