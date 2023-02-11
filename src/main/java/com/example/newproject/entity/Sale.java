package com.example.newproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "sales", schema = "public", catalog = "postgres")
public class Sale {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "product_id", nullable = false, length = 13)
    private String productId;
    @Basic
    @Column(name = "sell_price", nullable = true, precision = 2)
    private Double sellPrice;
    @Basic
    @Column(name = "sell_date", nullable = true)
    private LocalDate sellDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public LocalDate getSellDate() {
        return sellDate;
    }

    public void setSellDate(LocalDate sellDate) {
        this.sellDate = sellDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return id == sale.id && Objects.equals(productId, sale.productId) && Objects.equals(sellPrice, sale.sellPrice) && Objects.equals(sellDate, sale.sellDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, sellPrice, sellDate);
    }
}
