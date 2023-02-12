package com.example.newproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "sales", schema = "public", catalog = "postgres")
public class Sale {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "product_id", nullable = false, length = 13)
    private Integer productId;
    @Column(name = "sell_price")
    private Double sellPrice;
    @Column(name = "sell_date")
    private LocalDate sellDate;
}
