package com.javaproject.ProduktiService.repository;

import com.javaproject.ProduktiService.model.Produkti;
import org.springframework.data.repository.CrudRepository;

public interface ProduktRepository extends CrudRepository<Produkti, Integer> {

  Produkti findByEmri(String emri);
}