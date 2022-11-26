package br.inatel.projeto.model;

public class Unidade{
    private int idUnidade;
    private String localizacao;
    private boolean taxa;

    public Unidade(int idUnidade, String localizacao, boolean taxa) {
        this.idUnidade = idUnidade;
        this.localizacao = localizacao;
        this.taxa = taxa;
    }

    public int getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public boolean isTaxa() {
        return taxa;
    }

    public void setTaxa(boolean taxa) {
        this.taxa = taxa;
    }
}