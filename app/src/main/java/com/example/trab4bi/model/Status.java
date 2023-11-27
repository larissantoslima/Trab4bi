package com.example.trab4bi.model;

public class Status     {

    private String situacao;
    private String totalMembros;

    public Status() {
    }

    public Status(String situacao, String totalMembros) {
        this.situacao = situacao;
        this.totalMembros = totalMembros;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTotalMembros() {
        return totalMembros;
    }

    public void setTotalMembros(String totalMembros) {
        this.totalMembros = totalMembros;
    }
}
