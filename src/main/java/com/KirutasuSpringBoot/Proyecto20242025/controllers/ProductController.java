package com.KirutasuSpringBoot.Proyecto20242025.controllers;

import com.KirutasuSpringBoot.Proyecto20242025.configurations.ExternalizedConfigurations;
import com.KirutasuSpringBoot.Proyecto20242025.domain.Product;
import com.KirutasuSpringBoot.Proyecto20242025.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // con esto le indicamos a Spring que esto es un Bean tambien.
@RequestMapping ("/productos")
public class ProductController {

    //Inyeccion de dependencia por campo
    @Autowired //el uso pasa a ser de Spring, mejorando que no haya un alto acomplamiento
    //@Qualifier ("jsonResourceService") // se inyecta aqui el bean del servicio exacto que queremos inyectar y priorizar. Tiene prioridad sobre Primary
    // se comenta Qualifier porque estamos usando ConditionalOnProperty por tanto está ya en application.properties
    @Lazy
    private ProductService productsService;
    //Abajo Instancia de clase, sustituida por inyeccion (de campo) de dependencias mejor praxis
    //ProductService productsService = new ProductsServiceImpl(); // Modificamos para introducir el tipo de dato de la interfaz,
                                                                // y con polimorfismo dinamico podemos crear un objeto del tipo de la clase que implementa esta interfaz. Para escalabilidad
    //ProductsServiceImpl productsService = new ProductsServiceImpl();

    @Autowired //Lista la inyeccion de dependencias de Configuration
    private ExternalizedConfigurations externalizedConfigurations;


    @GetMapping
    public ResponseEntity<?> getProducts (){ // no va a retornar siempre la lista products, puede que necesite codigo de respuesta HTTP

        System.out.println(externalizedConfigurations); //llamamos al metodo toString sobrescrito en configurations, para que al ejecutar este endpoint mostrará este override //todo muy basico pero para el objetivo actual sirve

        List<Product> products = productsService.getProducts();

        return ResponseEntity.ok(products); //en el body irá la lista products, ya con buenas practicas
    }
}
