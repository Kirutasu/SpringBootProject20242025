package com.KirutasuSpringBoot.Proyecto20242025.controllers;

import com.KirutasuSpringBoot.Proyecto20242025.domain.Customer;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping ("/clientes/{username}")
    public Customer getCliente (@PathVariable String username) { // Algoritmo que nos permite encontrar un cliente (c) de acuerdo a su username
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null; // ahora no nos preocupamos de la arquitectura o buenas practicas, se irá corrigiendo mas adelante, esto NO es una buena practica
    }

    @PostMapping ("/clientes")
    public Customer postCliente (@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    @PutMapping ("/clientes")
    public Customer putCliente (@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getId() == customer.getId()) {
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return  c;
            }
        }
        return null; //TODO mala practica, pero no es el foco de este ejercicio concreto
    }

    @DeleteMapping ("/clientes/{id}")
    public Customer deleteCliente (@PathVariable int id) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                customers.remove(c);
                return c;
            }
        }
        return null; //TODO mala practica, pero no es el foco de este ejercicio concreto
    }

}
