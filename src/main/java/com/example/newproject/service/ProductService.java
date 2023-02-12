package com.example.newproject.service;

import com.example.newproject.dto.ProductSearchParams;
import com.example.newproject.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    Product update(Product product);
    void delete(int id);

    Product addProduct(Product product, ProductSearchParams params);


}
