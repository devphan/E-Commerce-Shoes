package com.ecommerce.shoes.controller.api;

import com.ecommerce.shoes.entity.Brand;
import com.ecommerce.shoes.exception.NotFoundException;
import com.ecommerce.shoes.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.MalformedURLException;
import java.util.List;


@RestController
@RequestMapping("/api/brands")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BrandRestController {
    private static String UPLOAD_DIR = System.getProperty("user.home") + "/upload";

    @Autowired
    private BrandService brandService;

    @GetMapping("")
    public ResponseEntity<?> getListBrand() {
        List<Brand> result = brandService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBrandById(@PathVariable int id) {
        Brand result = brandService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<?> createBrand(@RequestBody Brand entity) {
        Brand result = brandService.insert(entity);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBrand(@RequestBody Brand entity, @PathVariable int id) {
        brandService.update(id, entity);
        return ResponseEntity.ok("UPDATE SUCCESS");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable int id) {
        brandService.delete(id);
        return ResponseEntity.ok("DELETE SUCCESS");
    }

    @GetMapping("/file/{filename}")
    public ResponseEntity<?> download(@PathVariable String filename) {
        File file = new File(UPLOAD_DIR + "/" + filename);
        if (!file.exists()) {
            throw new NotFoundException("File not found");
        }

        UrlResource resource;
        try {
            resource = new UrlResource(file.toURI());
        } catch (MalformedURLException e) {
            throw new NotFoundException("File not found");
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(resource);
    }
}
