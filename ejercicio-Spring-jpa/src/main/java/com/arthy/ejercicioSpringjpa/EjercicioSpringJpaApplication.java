package com.arthy.ejercicioSpringjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EjercicioSpringJpaApplication {

	public static void main(String[] args) {

		/*
		** Ejercicio 3: Crear proyecto Spring Boot con dependencias
		*/
		ApplicationContext context = SpringApplication.run(EjercicioSpringJpaApplication.class, args);
		ContactoRepository repository = context.getBean(ContactoRepository.class);

		Contacto contacto1 = new Contacto(null, "Valentina", 15, "Colombia");
		Contacto contacto2 = new Contacto(null, "Arianna", 18,"México");

		repository.save(contacto1);
		repository.save(contacto2);
		System.out.println("Hay: " + repository.count() + " contactos en el repositorio.");
		System.out.println(repository.findAll());
		System.out.println("Existe el contacto: " + repository.findById(2L));

	}

}
