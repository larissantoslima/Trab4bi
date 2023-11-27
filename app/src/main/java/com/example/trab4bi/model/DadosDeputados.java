package com.example.trab4bi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosDeputados {

    private long id;
    private String uri;
    private String nome;
    private String siglaPartido;
    private String uriPartido;
    private String siglaUf;
    private int idLegislatura;
    private String urlFoto;
    private String email;
    private String rel;
    private String href;

    public DadosDeputados() {
    }

    public DadosDeputados(long id, String uri, String nome, String siglaPartido, String uriPartido, String siglaUf, int idLegislatura, String urlFoto, String email, String rel,String href ) {
        this.id = id;
        this.uri = uri;
        this.nome = nome;
        this.siglaPartido = siglaPartido;
        this.uriPartido = uriPartido;
        this.siglaUf = siglaUf;
        this.idLegislatura = idLegislatura;
        this.urlFoto = urlFoto;
        this.email = email;
        this.rel = rel;
        this.href = href;
    }

    public long getId() {
        return id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiglaPartido() {
        return siglaPartido;
    }

    public void setSiglaPartido(String siglaPartido) {
        this.siglaPartido = siglaPartido;
    }

    public String getUriPartido() {
        return uriPartido;
    }

    public void setUriPartido(String uriPartido) {
        this.uriPartido = uriPartido;
    }

    public String getSiglaUf() {
        return siglaUf;
    }

    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }

    public int getIdLegislatura() {
        return idLegislatura;
    }

    public void setIdLegislatura(int idLegislatura) {
        this.idLegislatura = idLegislatura;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }
}
