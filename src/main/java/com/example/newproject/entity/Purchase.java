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
@Table(name = "purchases", schema = "public", catalog = "postgres")
public class Purchase {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "product_id", nullable = false, length = 13)
    private Integer productId;
    @Column(name = "purchase_price")
    private Double purchasePrice;
    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

}
