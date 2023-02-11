package com.example.newproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "makers", schema = "public", catalog = "postgres")
public class Maker {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "maker_name", nullable = true, length = -1)
    private String makerName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maker maker = (Maker) o;
        return id == maker.id && Objects.equals(makerName, maker.makerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, makerName);
    }
}
