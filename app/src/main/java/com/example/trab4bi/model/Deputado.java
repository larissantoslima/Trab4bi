package com.example.trab4bi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Deputado {
    @JsonProperty("dados")
    private List<DadosDeputados> dados;

    @JsonProperty("links")
    private List<DadosDeputados> links;

    public List<DadosDeputados> getDados() {
        return dados;
    }

    public void setDados(List<DadosDeputados> dados) {
        this.dados = dados;
    }

    public List<DadosDeputados> getLinks() {
        return links;
    }

    public void setLinks(List<DadosDeputados> links) {
        this.links = links;
    }
}
