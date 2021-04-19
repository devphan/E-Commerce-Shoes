package com.ecommerce.shoes.controller.api;

import com.ecommerce.shoes.entity.Product;
import com.ecommerce.shoes.model.request.CreateProductReq;
import com.ecommerce.shoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public ResponseEntity<?> getListProductSale() {
        List<Product> result = productService.getListProductSale();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/create-product")
    public ResponseEntity<?> createProduct(CreateProductReq req) {
        productService.createProduct(req);
        return ResponseEntity.ok("CREATE SUCCESS");
    }


}
