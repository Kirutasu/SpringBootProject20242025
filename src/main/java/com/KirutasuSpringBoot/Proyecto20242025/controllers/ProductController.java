package com.KirutasuSpringBoot.Proyecto20242025.controllers;

import com.KirutasuSpringBoot.Proyecto20242025.domain.Product;
import com.KirutasuSpringBoot.Proyecto20242025.service.ProductsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/productos")
public class ProductController {

    ProductsServiceImpl productsService = new ProductsServiceImpl();

    @GetMapping
    public ResponseEntity<?> getProducts (){ // no va a retornar siempre la lista products, puede que necesite codigo de respuesta HTTP
        List<Product> products = productsService.getProducts();

        return ResponseEntity.ok(products); //en el body irá la lista products, ya con buenas practicas
    }
}
