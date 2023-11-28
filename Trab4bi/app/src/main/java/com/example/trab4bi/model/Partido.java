package com.example.trab4bi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Partido {
    @JsonProperty("dados")
    private List<DadosPartido> dados;

    public Partido() {
    }

    public Partido(List<DadosPartido> dados) {
        this.dados = dados;
    }

    public List<DadosPartido> getDados() {
        return dados;
    }

    public void setDados(List<DadosPartido> dados) {
        this.dados = dados;
    }
}
