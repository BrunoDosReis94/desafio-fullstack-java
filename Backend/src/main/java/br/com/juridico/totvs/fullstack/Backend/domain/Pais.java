package br.com.juridico.totvs.fullstack.Backend.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sigla;
    private String continente;
    private String ddi;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PontoTuristico> pontosTuristicos;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    public List<PontoTuristico> getPontosTuristicos() {
        return pontosTuristicos;
    }

    public void setPontosTuristicos(List<PontoTuristico> pontosTuristicos) {
        this.pontosTuristicos = pontosTuristicos;
    }
}