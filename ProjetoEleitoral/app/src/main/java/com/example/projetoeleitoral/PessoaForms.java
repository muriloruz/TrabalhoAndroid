package com.example.projetoeleitoral;

public class PessoaForms {
    private String nome;
    private String estCivil;
    private String telefone;
    private int idade;
    private String sexo;
    public static PessoaForms instace;


    private PessoaForms(){}

    public static PessoaForms getInstance(){
        if(instace == null) instace = new PessoaForms();
        return instace;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstCivil() {
        return estCivil;
    }

    public void setEstCivil(String estCivil) {
        this.estCivil = estCivil;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
