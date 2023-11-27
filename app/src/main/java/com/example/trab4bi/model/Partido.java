package com.example.trab4bi.model;

public class Partido {

    private Long id;
    private String nome;
    private Long numeroEleitoral;
    private String sigla;
    private Status Status;

    public Partido() {
    }

    public Partido(Long id, String nome, Long numeroEleitoral, String sigla, com.example.trab4bi.model.Status status) {
        this.id = id;
        this.nome = nome;
        this.numeroEleitoral = numeroEleitoral;
        this.sigla = sigla;
        Status = status;
    }

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

    public Long getNumeroEleitoral() {
        return numeroEleitoral;
    }

    public void setNumeroEleitoral(Long numeroEleitoral) {
        this.numeroEleitoral = numeroEleitoral;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public com.example.trab4bi.model.Status getStatus() {
        return Status;
    }

    public void setStatus(com.example.trab4bi.model.Status status) {
        Status = status;
    }
}
