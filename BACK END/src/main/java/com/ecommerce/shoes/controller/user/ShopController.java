package com.ecommerce.shoes.controller.user;

import com.ecommerce.shoes.entity.Product;
import com.ecommerce.shoes.service.BrandService;
import com.ecommerce.shoes.service.CategoryService;
import com.ecommerce.shoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {
    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String indexPage(Model model) {
        model.addAttribute("productsDiscount", productService.getListProductSale());
        model.addAttribute("productsBestSeller", productService.getListProductBestSeller());
        return "shop/index";
    }

    @GetMapping("/products")
    public String getPageProduct(Model model, Pageable pageable) {
        Page<Product> products = productService.findAllPage(pageable);
        model.addAttribute("products", products);
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "shop/product";
    }
}
