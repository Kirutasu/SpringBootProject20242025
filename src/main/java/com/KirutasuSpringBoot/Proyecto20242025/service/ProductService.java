package com.KirutasuSpringBoot.Proyecto20242025.service;

import com.KirutasuSpringBoot.Proyecto20242025.domain.Product;

import java.util.List;

public interface ProductService {


    List<Product> getProducts (); //No hay que añadir la logica del metodo, en las interfaces los metodos NO se implementan, solo se definen. Eso lo hará el servicio
}
