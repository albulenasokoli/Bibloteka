package com.javaproject.ProduktiService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produkti {

  private Integer id;
  private String emri;
  private String kategoria;
  private int nrSasise;

  public Produkti() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getId() {
    return id;
  }

  public int getNrSasise() {
    return nrSasise;
  }

  public String getEmri() {
    return emri;
  }

  public String getKategoria() {
    return kategoria;
  }

  public void setEmri(String emri) {
    this.emri = emri;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setKategoria(String kategoria) {
    this.kategoria = kategoria;
  }

  public void setNrSasise(int nrSasise) {
    this.nrSasise = nrSasise;
  }

}
