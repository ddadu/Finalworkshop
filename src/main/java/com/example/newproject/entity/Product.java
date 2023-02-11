package com.example.newproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "products", schema = "public", catalog = "postgres")
public class Product {
    @Basic
    @Column(name = "id")
    private Integer id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ean_code")
    private String eanCode;
    @Basic
    @Column(name = "product_name", nullable = true)
    private String productName;
    @Basic
    @Column(name = "description", nullable = true)
    private String description;
    @Basic
    @Column(name = "maker_id", nullable = false)
    private Integer makerId;
    @Basic
    @Column(name = "category_id", nullable = false)
    private int categoryId;
    @Basic
    @Column(name = "sell_price", nullable = true)
    private BigDecimal sellPrice;
    @Basic
    @Column(name = "remaining", nullable = true)
    private Integer remaining;
    @Basic
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Basic
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEanCode() {
        return eanCode;
    }

    public void setEanCode(String eanCode) {
        this.eanCode = eanCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMakerId() {
        return makerId;
    }

    public void setMakerId(Integer makerId) {
        this.makerId = makerId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return categoryId == product.categoryId && Objects.equals(id, product.id) && Objects.equals(eanCode, product.eanCode) && Objects.equals(productName, product.productName) && Objects.equals(description, product.description) && Objects.equals(makerId, product.makerId) && Objects.equals(sellPrice, product.sellPrice) && Objects.equals(remaining, product.remaining) && Objects.equals(createdAt, product.createdAt) && Objects.equals(updatedAt, product.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eanCode, productName, description, makerId, categoryId, sellPrice, remaining, createdAt, updatedAt);
    }
}
