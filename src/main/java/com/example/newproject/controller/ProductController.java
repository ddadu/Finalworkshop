package com.example.newproject.controller;

import com.example.newproject.dto.ProductSearchParams;
import com.example.newproject.entity.Product;
import com.example.newproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity <Product> addProduct(@RequestBody Product product, ProductSearchParams params){
        Product registered = productService.addProduct(product, params);
        var location = UriComponentsBuilder.fromPath("/products/").buildAndExpand(registered.getId()).toUri();
        return ResponseEntity.created(location).body(product);
    }
    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }
    @GetMapping("/{id}")
    public Product findById(@PathVariable int id){
        return productService.findById(id);
    }
    @PutMapping
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        productService.delete(id);
    }
}
