package br.inatel.projeto.model;

public class Cliente {
    private String nome;
    private String CPF;
    private String genero;
    private String senha;

    public Cliente(String nome,String CPF,String genero,String senha){
        this.nome = nome;
        this.CPF = CPF;
        this.genero = genero;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
