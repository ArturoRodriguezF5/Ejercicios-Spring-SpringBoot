package com.arthycode.SpringRestApiHeladeria;

import com.arthycode.SpringRestApiHeladeria.entity.Helado;
import com.arthycode.SpringRestApiHeladeria.repository.HeladeriaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringRestApiHeladeriaApplication {

	public static void main(String[] args) {

		ApplicationContext contex = SpringApplication.run(SpringRestApiHeladeriaApplication.class, args);
		HeladeriaRepository repo = contex.getBean(HeladeriaRepository.class);

		Helado helado1 = new Helado(null, "IceCreamPeanut", "Peanut", true,23.5F);
		repo.save(helado1);
		System.out.println(repo.findAll());
	}

}
