package br.inatel.projeto.model;

import br.inatel.projeto.control.DatabaseProduto;
import br.inatel.projeto.control.DatabaseSAC;

import java.util.ArrayList;

public class Unidade{
    private int idUnidade;
    private String localizacao;
    private boolean taxa;
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private SAC sac = null;
    DatabaseSAC SACdb = new DatabaseSAC();
    DatabaseProduto prodDB = new DatabaseProduto();

    public Unidade(int idUnidade, String localizacao, boolean taxa) {
        this.idUnidade = idUnidade;
        this.localizacao = localizacao;
        this.taxa = taxa;
        sac = SACdb.researchSAC(this);
        produtos = prodDB.researchProduto(this);
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

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public SAC getSac() {
        return sac;
    }

    public void setSac(SAC sac) {
        this.sac = sac;
    }

    @Override
    public String toString(){
        return localizacao;
    }
}