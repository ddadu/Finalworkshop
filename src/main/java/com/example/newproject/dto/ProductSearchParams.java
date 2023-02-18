package com.example.newproject.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Setter
@Getter
public class ProductSearchParams {
    private Integer id;
    private Integer eanCode;
    private Integer makerId;
    private Integer categoryId;
    private Integer sellPrice;
    private String productName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate createdAt;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate updateAt;
}

