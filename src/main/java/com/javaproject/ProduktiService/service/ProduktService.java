package com.javaproject.ProduktiService.service;

import com.javaproject.ProduktiService.model.Produkti;
import com.javaproject.ProduktiService.repository.ProduktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduktService {

  private final ProduktRepository repo;

  @Autowired
  public ProduktService(ProduktRepository repo) {
    this.repo = repo;
  }

  public List<Produkti> listAll() {
    return (List<Produkti>) repo.findAll();
  }

  public void save(Produkti produkt) {
    repo.save(produkt);
  }

  public Produkti get(Integer id) {
    return repo.findById(id).get();
  }

  public void delete(Integer id) {
    repo.deleteById(id);
  }

}
