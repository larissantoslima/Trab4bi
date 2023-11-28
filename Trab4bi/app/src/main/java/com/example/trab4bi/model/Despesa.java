package com.example.trab4bi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Despesa {
    private List<DadosDespesa> dados;

    public Despesa() {
    }

    public Despesa(List<DadosDespesa> dados) {
        this.dados = dados;
    }

    public List<DadosDespesa> getDados() {
        return dados;
    }

    public void setDados(List<DadosDespesa> dados) {
        this.dados = dados;
    }
}
