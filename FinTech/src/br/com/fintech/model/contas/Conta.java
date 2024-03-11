package br.com.fintech.model.contas;

import br.com.fintech.model.Acoes;

import java.util.List;

public class Conta {
    private Integer tipoConta;
    private Integer numero;
    private Double saldo;
    private Double limite;
    private List<Acoes> extrato;
    private String banco;
    private String cliente;

    public Conta() {

    }

    public Integer getTipoConta() {
        return this.tipoConta;
    }

    public void setTipoConta(Integer tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimite() {
        return this.limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public List<Acoes> getExtrato() {
        return this.extrato;
    }

    public void setExtrato(List<Acoes> extrato) {
        this.extrato = extrato;
    }

    public String getBanco() {
        return this.banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getCliente() {
        return this.cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer gerarNumero(int cont) {
        return cont;
    }
    public void verSaldo() {
        System.out.println(this.saldo);
    }

    public void registrarAcao(Acoes acao) {
        this.extrato.add(acao);
    }

    public void depositar(Double valor) {
        if(valor > 0) {
            this.saldo += valor;
            System.out.printf("Deposito efetuado no valor de R$%f \n", valor);
            return;
        }

        System.out.println("O valor do deposito tem que ser maior que 0");
    }

    public void sacar(Double valor) {
        if(valor > 0) {
            this.saldo -= valor;
            System.out.printf("Saque efetuado no valor de R$%f \n", valor);
            return;
        }

        System.out.println("O valor do saque tem que ser maior que 0");
    }

    public String toString() {
        return "{ tipoConta: " + this.tipoConta + ", \n" + "numero: " + this.numero + ", \n" + "saldo: " + this.saldo +
                ", \n" + "limite: " + this.limite + ", \n" + "extrato: {" + this.extrato + "}, \n" + "banco: " + this.banco +
                ", \n" + "cliente: " + this.cliente;
    }
}
