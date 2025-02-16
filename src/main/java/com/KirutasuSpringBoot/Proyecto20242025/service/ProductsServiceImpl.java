package com.KirutasuSpringBoot.Proyecto20242025.service;

import com.KirutasuSpringBoot.Proyecto20242025.domain.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsServiceImpl {


    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Laptop", 799.99, 10),
            new Product(2, "Smartphone", 499.99, 25),
            new Product(3, "Tablet", 299.99, 15),
            new Product(4, "Smartwatch", 199.99, 30)
    ));

    public List<Product> getProducts (){ // metodo que devuelve la lista de productos, pequeño servicio pero ya existente
        return products;
    }

}
