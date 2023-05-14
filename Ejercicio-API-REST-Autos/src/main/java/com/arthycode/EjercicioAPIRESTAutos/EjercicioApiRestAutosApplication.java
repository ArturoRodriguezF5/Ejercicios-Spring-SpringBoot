package com.arthycode.EjercicioAPIRESTAutos;

import com.arthycode.EjercicioAPIRESTAutos.entities.Auto;
import com.arthycode.EjercicioAPIRESTAutos.repository.AutosRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EjercicioApiRestAutosApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(EjercicioApiRestAutosApplication.class, args);
		AutosRepository repo = context.getBean(AutosRepository.class);

		Auto auto1 = new Auto(null, "Ford", "EcoSport", 4, false);
		repo.save(auto1);
		System.out.println(repo.findAll());
	}

}
