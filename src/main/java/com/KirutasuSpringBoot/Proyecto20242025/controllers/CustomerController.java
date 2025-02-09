package com.KirutasuSpringBoot.Proyecto20242025.controllers;

import com.KirutasuSpringBoot.Proyecto20242025.domain.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123, "Gerardo Lopez", "gerardol", "contraseña123"),
            new Customer(456, "Alejandra García", "alegarcia", "clave456"),
            new Customer(789, "Laura Sanchez", "lauras", "secreto789"),
            new Customer(234, "Carlos Martínez", "carlosm", "password234")
    ));

    @GetMapping ("/clientes")
    public List<Customer> getCustomers() {
        return customers;
    }
}
