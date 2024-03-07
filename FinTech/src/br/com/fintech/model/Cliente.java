package br.com.fintech.model;

import br.com.fintech.model.contas.IConta;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String email;
    private String cpf;
    private List<IConta> contas = new ArrayList<>();

    public Cliente () {}

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<IConta> getContas() {
        return this.contas;
    }

    public void setContas(List<IConta> contas) {
        this.contas = contas;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void criarConta() {

    }

    public void encerrarConta() {

    }

}
