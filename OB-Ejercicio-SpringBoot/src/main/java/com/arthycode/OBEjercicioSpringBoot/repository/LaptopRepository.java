package com.arthycode.OBEjercicioSpringBoot.repository;

import com.arthycode.OBEjercicioSpringBoot.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
