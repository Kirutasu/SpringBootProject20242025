package com.KirutasuSpringBoot.Proyecto20242025.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLOutput;

@Configuration //esta anotacion le indica a Spring que es un archivo de configuracion que deberá tratarse como un bean.
// No es un bean, pero usaremos inyeccion de dependencias. Si no lo indicamos, Spring no lo va a gestionar
@ConfigurationProperties (prefix = "app")// indispensable porque le vamos a indicar a Spring cuales serán las propiedades de configuracion que vamos a utilizar (en este caso las de application properties)
public class ExternalizedConfigurations {

    private String name;
    private String version;
    private String author;
    private String language;
    private String country;
    //en este caso lo mas importante es seguir el ORDEN (aunque que se llamen igual tambien, pero no lo tiene en cuenta)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() { // Para comprobar si funciona bien esta configuracion y estructura
        // , por el momento unicamente sacaremos en pantalla el contenido de estos atributos. Podemos manipular de este lado el contenido del archivo application.properties
        // Todo alternativa o bases de datos para comprobarlo
        return "Externalized configurations: " + "\n" +
                "nombre: " + this.name + "\n" +
                "version: " + this.version + "\n" +
                "autor: " + this.author + "\n" +
                "idioma: " + this.language + "\n" +
                "pais: " + this.country;
    }

}
