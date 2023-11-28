package com.example.trab4bi.model;

public class DadosPartido {

    private int id;
    private String sigla;
    private String nome;
    private String uri;

    public DadosPartido() {
    }

    public DadosPartido(int id, String sigla, String nome, String uri) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
        this.uri = uri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
