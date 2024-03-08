package br.com.fintech.model;

import br.com.fintech.model.contas.*;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String email;
    private String cpf;
    private List<Conta> contas;

    public Cliente (String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.contas = new ArrayList<>();
    }

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

    public List<Conta> getContas() { return this.contas; }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void criarConta(int tipoConta) {
        boolean contaValida = this.verificarTipoDaConta(tipoConta);

        if(!contaValida) {
            System.out.printf("Não é possível adicionar mais de 1 conta do mesmo tipo [Tipo escolhido: %d] \n", tipoConta);
            return;
        }

        switch (tipoConta) {
            case 1:
                Conta contaCorrente = new Conta(new ContaCorrente());
                this.contas.add(contaCorrente);
                break;
            case 2:
                Conta contaPoupanca = new Conta(new ContaPoupanca());
                this.contas.add(contaPoupanca);
                break;
            case 3:
                Conta contaInvestimento = new Conta(new ContaInvestimento());
                this.contas.add((contaInvestimento));
                break;
            default:
                System.out.println("Opção inválida, digite novamente");
                break;
        }
    }

    private boolean verificarTipoDaConta(int tipoConta) {
        int cont = 0;
        for(Conta conta:this.contas) {
            if(conta.getTipoConta() == tipoConta) {
                cont++;
            }
        }

        return cont > 0 ? false : true;
    }

    public void encerrarConta(int tipoConta) {
        if(findConta(tipoConta) != null) {
            this.contas.remove(findConta(tipoConta));
            return;
        }

        System.out.printf("Conta não encontrado do tipo %d", tipoConta);
    }

    private Conta findConta(int tipoConta) {
        for(Conta conta:this.contas) {
            if(conta.getTipoConta() == tipoConta) {
                return conta;
            }
        }

        return null;
    }
}
