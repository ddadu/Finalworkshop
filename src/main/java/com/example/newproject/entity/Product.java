package com.example.newproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "products", schema = "public", catalog = "postgres")
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "ean_code", nullable = false)
    private String eanCode;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "description")
    private String description;
    @Column(name = "maker_id", nullable = false)
    private Integer makerId;
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;
    @Column(name = "sell_price")
    private Integer sellPrice;
    @Column(name = "remaining")
    private Integer remaining;
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }



}
