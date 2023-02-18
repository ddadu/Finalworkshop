package com.example.newproject.service;


import com.example.newproject.dto.ProductSearchParams;
import com.example.newproject.entity.Product;
import com.example.newproject.entity.Product_;
import com.example.newproject.exception.NotFoundException;
import com.example.newproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Page<Product> getProducts(ProductSearchParams params, Pageable pageable) {
        return productRepository.findAll((root, query, cb) -> {
            Predicate predicate = cb.conjunction();
            if(params.getId() !=null){
                predicate = cb.and(predicate, cb.equal(root.get(Product_.ID), params.getId()));
            }
            if(params.getEanCode() !=null){
                predicate = cb.and(predicate, cb.equal(root.get(Product_.EAN_CODE), params.getEanCode()));
            }
            if(StringUtils.isNotEmpty(params.getProductName())){
                predicate = cb.and(predicate, cb.like(root.get(Product_.PRODUCT_NAME), params.getProductName()));
            }
            if(params.getCategoryId() != null){
                predicate = cb.and(predicate, cb.equal(root.get(Product_.CATEGORY_ID), params.getCategoryId()));
            }
            if(params.getMakerId() != null){
                predicate = cb.and(predicate, cb.equal(root.get(Product_.MAKER_ID),params.getMakerId()));
            }
            if(params.getSellPrice() != null){
                predicate = cb.and(predicate, cb.equal(root.get(Product_.SELL_PRICE), params.getSellPrice()));
            }
            return predicate;

        }, pageable);
    }


    @Override
    public Product getProduct(int id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Product not found"));
    }
    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }
    @Override
    public void delete(int id) {
        productRepository.deleteById(id);

    }

    @Override
    public Product addProduct(Product product) {
        product.setEanCode(product.getEanCode());
        return productRepository.save(product);
    }
}
