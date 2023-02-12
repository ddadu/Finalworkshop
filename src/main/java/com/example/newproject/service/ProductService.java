package com.example.newproject.service;

import com.example.newproject.dto.ProductSearchParams;
import com.example.newproject.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
@Service
public interface ProductService {
    Page<Product> getProducts(ProductSearchParams params, Pageable pageable);
    Product getProduct(int id);
    Product update(Product product);
    void delete(int id);

    Product addProduct(Product eanCode);


}
