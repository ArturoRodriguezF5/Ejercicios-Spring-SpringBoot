package com.arthycode.SpringRestApiHeladeria.repository;

import com.arthycode.SpringRestApiHeladeria.entity.Helado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeladeriaRepository extends JpaRepository<Helado, Long> {

}
