package com.KirutasuSpringBoot.Proyecto20242025.controllers;

import com.KirutasuSpringBoot.Proyecto20242025.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping ("/clientes")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123, "Gerardo Lopez", "gerardol", "contraseña123"),
            new Customer(456, "Alejandra García", "alegarcia", "clave456"),
            new Customer(789, "Laura Sanchez", "lauras", "secreto789"),
            new Customer(234, "Carlos Martínez", "carlosm", "password234")
    ));

    @GetMapping
    //@RequestMapping (method = RequestMethod.GET) // va a utilizar el mapeo de clase, y estamos informando que va a gestionar una solicitud del tipo GET. Alternativa usando el getmapping o requestmapping
    public ResponseEntity <List<Customer>> getCustomers() {
        return ResponseEntity.ok(customers);
    }

    @GetMapping ("/{username}")
    //@RequestMapping (value = "/{username}", method = RequestMethod.GET) //Validado para recibir parametro web. probando a aplicar RequestMapping a niveles metodo
    public ResponseEntity <?> getCliente (@PathVariable String username) { // Algoritmo que nos permite encontrar un cliente (c) de acuerdo a su username todo se añade ? como posible devolucion porque no siempre se devolvera un "customer" (sirve para el codigo de error con body")
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con username: " + username);
        //return null; // ahora no nos preocupamos de la arquitectura o buenas practicas, se irá corrigiendo mas adelante, esto NO es una buena practica
    }

    @PostMapping
    //@RequestMapping (method = RequestMethod.POST)
    public ResponseEntity<?> postCliente (@RequestBody Customer customer) {
        customers.add(customer);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest() // aqui obtenemos la URI base
                .path("/{username}")  // aqui añadimos a la URL el parametro que es la variable que se utiliza
                .buildAndExpand(customer.getUsername()) // toma el valor propocionado y lo inserta en el segmento de ruta (en este caso username)
                .toUri(); // finaliza la construccion de la URI, que quedaría creada //todo todas las URL son URI pero no todas las URI son URL

        return ResponseEntity.created(location).body(customer); //si quieres mostrar aquello creado, mejor praxis
        //return ResponseEntity.created(location).build();  // solo trayendo el codigo 201 sin traer nada pero /todo con la URI en el header

        // return ResponseEntity.status(HttpStatus.CREATED).body("El cliente con username: " + customer.getUsername()+ " fue creado con exito");
        //return customer;
    }

    @PutMapping
    //@RequestMapping (method = RequestMethod.PUT)
    public ResponseEntity<?> putCliente (@RequestBody Customer customer) { // ? porque puede variar el retorno, al agregar un mensaje personalizado
        for (Customer c : customers) {
            if (c.getId() == customer.getId()) {
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build(); //simplificando codigo de respuesta HTTP
        // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado: " + customer.getId());
        //return null; //TODO mala practica, pero no es el foco de este ejercicio concreto
    }

    @DeleteMapping ("/{id}")
    //@RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCliente (@PathVariable int id) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                customers.remove(c);
                return ResponseEntity.noContent().build(); //simplificando codigo de respuesta HTTP
                // return ResponseEntity.status(HttpStatus.NO_CONTENT)
                //        .body("Cliente eliminado satisfactoriamente: " + id); //al ser sin contenido el mensaje no saldrá
            }
        }
        return ResponseEntity.notFound().build(); //simplificando codigo de respuesta HTTP (igualmente no saldrá el comentario en postman, dependerá de cada proyecto u ocasion
        // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado: " + id);
        //return null; //TODO mala practica, pero no es el foco de este ejercicio concreto
    }

    @PatchMapping
    // @RequestMapping (method = RequestMethod.PATCH)
    public ResponseEntity<?> patchCliente (@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getId() == customer.getId()){ // comprobar que el ID que viene, coincida con uno en nuestra base de datos

                if(customer.getName() != null) { //comprobar que el campo no venga nulo
                    c.setName(customer.getName());
                }

                if (customer.getUsername() != null) {
                    c.setUsername(customer.getUsername());
                }

                if (customer.getPassword() != null) {
                    c.setPassword(customer.getPassword());
                }
                return ResponseEntity.ok("Cliente modificado satisfactoriamente: " + customer.getId()); // id porque es inmutable
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con el id: " + customer.getId());
        //return null; //TODO mala practica, pero no es el foco de este ejercicio concreto
    }

}
