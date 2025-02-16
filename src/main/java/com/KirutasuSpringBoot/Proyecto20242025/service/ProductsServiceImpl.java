package com.KirutasuSpringBoot.Proyecto20242025.service;

import com.KirutasuSpringBoot.Proyecto20242025.domain.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Lazy
// @Primary NO quiero que sea este el servicio que se ejecute en este momento
@Service //("listResourceService") //comento los () porque estamos usando ConditionalOnProperty, que es donde está el nombre del servicio
// indica a Spring que esto es un Bean de servicio. Spring almacena esto en su contenedor, para cuando creemos una dependencia e inyectarla, spring gestionará la creacion de instancias de esa clase
@ConditionalOnProperty (name = "service.products", havingValue = "list")
public class ProductsServiceImpl implements ProductService { // implementamos la interfaz, que incluye por contrato los metodos que aqui SI, se implementan (agregamos cuerpo/comportamiento)

    public ProductsServiceImpl () {
        System.out.println("Comprobando la creacion de bean de servicio (instancia a esta clase) mediante anotacion @Lazy"); //anotarla tanto en el servicio que queremos diferir la creacion, como en el controlador.
    }

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Laptop", 799.99, 10),
            new Product(2, "Smartphone", 499.99, 25),
            new Product(3, "Tablet", 299.99, 15),
            new Product(4, "Smartwatch", 199.99, 30)
    ));

    @Override // no es sobreescribir como tal en este caso, pero es un comportamiento que no existe en la interfaz, es por buena praxis
    public List<Product> getProducts (){ // metodo que devuelve la lista de productos, pequeño servicio pero ya existente
        return products;
    }

}
