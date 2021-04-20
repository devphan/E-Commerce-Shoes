package com.ecommerce.shoes.controller.api;

import com.ecommerce.shoes.entity.Category;
import com.ecommerce.shoes.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> getListCategory() {
        List<Category> result = categoryService.findAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<?> createCategory(@RequestBody Category entity) {
        categoryService.insert(entity);
        return ResponseEntity.ok("CREATE SUCCESS");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody Category entity, @PathVariable int id) {
        categoryService.update(id, entity);
        return ResponseEntity.ok("UPDATE SUCCESS");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id) {
        categoryService.delete(id);
        return ResponseEntity.ok("DELETE SUCCESS");
    }


}
