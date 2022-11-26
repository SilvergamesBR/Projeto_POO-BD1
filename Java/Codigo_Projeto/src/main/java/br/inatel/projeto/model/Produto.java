package br.inatel.projeto.model;

public class Produto {
    private int codigoProduto;
    private int unidade_idUnidade;
    private String nome;
    private float valor;
    private String descricao;
    private int quantidade;

    public Produto(int codigoProduto, int unidade_idUnidade, String nome, float valor, String descricao, int quantidade) {
        this.codigoProduto = codigoProduto;
        this.unidade_idUnidade = unidade_idUnidade;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getUnidade_idUnidade() {
        return unidade_idUnidade;
    }

    public void setUnidade_idUnidade(int unidade_idUnidade) {
        this.unidade_idUnidade = unidade_idUnidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
