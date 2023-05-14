package com.arthycode.EjercicioAPIRESTAutos.repository;

import com.arthycode.EjercicioAPIRESTAutos.entities.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutosRepository extends JpaRepository<Auto, Long> {
}
