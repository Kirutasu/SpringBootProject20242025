package com.KirutasuSpringBoot.Proyecto20242025.service;

import com.KirutasuSpringBoot.Proyecto20242025.domain.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

// @Primary //Spring da prioridad a este servicio a la hora de existir mas de una implementacion
@Service ("jsonResourceService") //bean de servicio
public class ProductsServiceJSONImpl implements ProductService{

    @Override
    public List<Product> getProducts() { //lo añadimos con implement methods, pero lo adaptamos a lo que queremos que haga
        List<Product> products;

        try {
            products = new ObjectMapper() //Clase perteneciente a biblioteca Jackson
                    .readValue(this.getClass().getResourceAsStream("/products.json"), //metodo de la clase Object mapper, pide 2 parametros, nombre de archivo json y el tipo de coleccion que se va a utilizar para deserializar)
                            new TypeReference<List<Product>>() {});
            return products;
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
