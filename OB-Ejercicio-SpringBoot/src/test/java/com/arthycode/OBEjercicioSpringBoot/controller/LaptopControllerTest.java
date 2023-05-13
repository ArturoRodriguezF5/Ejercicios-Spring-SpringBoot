package com.arthycode.OBEjercicioSpringBoot.controller;

import com.arthycode.OBEjercicioSpringBoot.entity.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {
    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;
    @BeforeEach
    void setup() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }
    @Test
    void findAll() {
        ResponseEntity<Laptop[]> respLap = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
        assertEquals(HttpStatus.OK,respLap.getStatusCode());
        assertEquals(200, respLap.getStatusCode().value());

        List<Laptop> laptops = Arrays.asList(respLap.getBody());
        System.out.println(laptops.size());
    }

    @Test
    void findById() {
        ResponseEntity<Laptop> respLap = testRestTemplate.getForEntity("/api/laptops/2", Laptop.class);
        assertEquals(HttpStatus.NOT_FOUND,respLap.getStatusCode());
    }

    @Test
    void crearLaptop() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                        "marca": "Gigabyte",
                        "modelo": "G6735",
                        "touch": false
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);
        Laptop result = response.getBody();
        assertEquals(1L, result.getId());
        assertEquals("Gigabyte", result.getMarca());
    }

    @Test
    void update() {
        crearLaptop();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                        "id": 1,
                        "marca": "Gigabyte",
                        "modelo": "G6735",
                        "touch": false
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops/1", HttpMethod.PUT, request, Laptop.class);
        Laptop result = response.getBody();
        assertEquals(null, result.getId());
    }

    @Test
    void delete() {
        testRestTemplate.delete("/api/laptops/1", HttpMethod.DELETE, Laptop.class);
    }

    @Test
    void deleteAll() {
        testRestTemplate.delete("/api/laptops", HttpMethod.DELETE, Laptop.class);
    }
}