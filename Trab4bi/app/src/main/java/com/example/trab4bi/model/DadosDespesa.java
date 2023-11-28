package com.example.trab4bi.model;

public class DadosDespesa {
    private int ano;
    private int mes;
    private String tipoDespesa;
    private long codDocumento;
    private String tipoDocumento;
    private int codTipoDocumento;
    private String dataDocumento;
    private String numDocumento;
    private double valorDocumento;
    private String urlDocumento;
    private String nomeFornecedor;
    private String cnpjCpfFornecedor;
    private double valorLiquido;
    private double valorGlosa;
    private String numRessarcimento;
    private long codLote;
    private int parcela;

    public DadosDespesa() {
    }

    public DadosDespesa(int ano, int mes, String tipoDespesa, long codDocumento, String tipoDocumento, int codTipoDocumento, String dataDocumento, String numDocumento, double valorDocumento, String urlDocumento, String nomeFornecedor, String cnpjCpfFornecedor, double valorLiquido, double valorGlosa, String numRessarcimento, long codLote, int parcela) {
        this.ano = ano;
        this.mes = mes;
        this.tipoDespesa = tipoDespesa;
        this.codDocumento = codDocumento;
        this.tipoDocumento = tipoDocumento;
        this.codTipoDocumento = codTipoDocumento;
        this.dataDocumento = dataDocumento;
        this.numDocumento = numDocumento;
        this.valorDocumento = valorDocumento;
        this.urlDocumento = urlDocumento;
        this.nomeFornecedor = nomeFornecedor;
        this.cnpjCpfFornecedor = cnpjCpfFornecedor;
        this.valorLiquido = valorLiquido;
        this.valorGlosa = valorGlosa;
        this.numRessarcimento = numRessarcimento;
        this.codLote = codLote;
        this.parcela = parcela;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public long getCodDocumento() {
        return codDocumento;
    }

    public void setCodDocumento(long codDocumento) {
        this.codDocumento = codDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public void setCodTipoDocumento(int codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    public String getDataDocumento() {
        return dataDocumento;
    }

    public void setDataDocumento(String dataDocumento) {
        this.dataDocumento = dataDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public double getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(double valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public String getUrlDocumento() {
        return urlDocumento;
    }

    public void setUrlDocumento(String urlDocumento) {
        this.urlDocumento = urlDocumento;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getCnpjCpfFornecedor() {
        return cnpjCpfFornecedor;
    }

    public void setCnpjCpfFornecedor(String cnpjCpfFornecedor) {
        this.cnpjCpfFornecedor = cnpjCpfFornecedor;
    }

    public double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public double getValorGlosa() {
        return valorGlosa;
    }

    public void setValorGlosa(double valorGlosa) {
        this.valorGlosa = valorGlosa;
    }

    public String getNumRessarcimento() {
        return numRessarcimento;
    }

    public void setNumRessarcimento(String numRessarcimento) {
        this.numRessarcimento = numRessarcimento;
    }

    public long getCodLote() {
        return codLote;
    }

    public void setCodLote(long codLote) {
        this.codLote = codLote;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }
}
