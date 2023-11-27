package com.example.trab4bi.model;

import java.util.ArrayList;
import java.util.List;

public class Deputado {

    private List<DeputadoDados> dados;
    private List<DeputadoLink> links;

    public List<DeputadoDados> getDados() {
        return dados;
    }

    public void setDados(List<DeputadoDados> dados) {
        this.dados = dados;
    }

    public List<DeputadoLink> getLinks() {
        return links;
    }

    public void setLinks(List<DeputadoLink> links) {
        this.links = links;
    }
}
