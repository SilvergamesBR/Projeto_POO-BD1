package br.inatel.projeto.model;

public class SAC {
    private int unidade_idUnidade;
    private int idSAC;
    private String telefone;
    private String email;

    public SAC(int unidade_idUnidade, int idSAC, String telefone, String email) {
        this.unidade_idUnidade = unidade_idUnidade;
        this.idSAC = idSAC;
        this.telefone = telefone;
        this.email = email;
    }

    public int getUnidade_idUnidade() {
        return unidade_idUnidade;
    }

    public void setUnidade_idUnidade(int unidade_idUnidade) {
        this.unidade_idUnidade = unidade_idUnidade;
    }

    public int getIdSAC() {
        return idSAC;
    }

    public void setIdSAC(int idSAC) {
        this.idSAC = idSAC;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
