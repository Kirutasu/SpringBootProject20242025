package com.KirutasuSpringBoot.Proyecto20242025.domain;

public class Product {

    // ya no usaremos los valores primitivos al generar los atributos de nuestro producto
    private Integer id;
    private String name;
    private Double precio;
    private Integer stock;

    public Product(Integer id, String name, Double precio, Integer stock) {
        this.id = id;
        this.name = name;
        this.precio = precio;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
