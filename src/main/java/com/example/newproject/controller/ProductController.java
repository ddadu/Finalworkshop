package com.example.newproject.controller;


import com.example.newproject.dto.ProductSearchParams;
import com.example.newproject.entity.Product;
import com.example.newproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.print.Pageable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity <Product> addProduct(@RequestBody Product eanCode){
        productService.addProduct(eanCode);
        var location = UriComponentsBuilder.fromPath("/products/" + eanCode.getId()).build().toUri();
        return ResponseEntity.created(location).body(eanCode);
    }
    @GetMapping
    public Page<Product> getProducts(@RequestParam(required = false,defaultValue = "1") int page,
                                     @RequestParam(required = false, defaultValue = "5")int size,
                                     @RequestParam(required = false, defaultValue = "DESC")Sort.Direction direction,
                                     @RequestParam(required = false, defaultValue = "ean_code")String field,
                                     ProductSearchParams params){
        Sort sorter = Sort.by(direction, field);
        return productService.getProducts(params, (Pageable) PageRequest.of(page, size, sorter));
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.getProduct(id);
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
