package com.example.projetoeleitoral;

public class PessoaLogin {
    private String nome= "admin,entrevistador";
    private String senha = "admin,entrevistador";
    private String pessoa;
    public static PessoaLogin instance;

    private PessoaLogin(){}

    public static PessoaLogin getInstance(){
        if(instance == null) instance = new PessoaLogin();
        return instance;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }
}
