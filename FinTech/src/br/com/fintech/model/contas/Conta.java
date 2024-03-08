package br.com.fintech.model.contas;

import br.com.fintech.model.Transacao;
import java.util.List;

public class Conta {
    private Integer tipoConta;
    private Integer numero;
    private Double saldo;
    private Double limite;
    private List<Transacao> extrato;
    private String banco;

    public Conta() {

    }
    public Conta(ContaCorrente contaCorrente) {
        this.tipoConta = contaCorrente.getTipoConta();
        this.numero = contaCorrente.getNumero();
        this.saldo = contaCorrente.getSaldo();
        this.limite = contaCorrente.getLimite();
        this.extrato = contaCorrente.getExtrato();
        this.banco = contaCorrente.getBanco();
    }

    public Conta(ContaPoupanca contaPoupanca) {
        this.tipoConta = contaPoupanca.getTipoConta();
        this.numero = contaPoupanca.getNumero();
        this.saldo = contaPoupanca.getSaldo();
        this.limite = contaPoupanca.getLimite();
        this.extrato = contaPoupanca.getExtrato();
        this.banco = contaPoupanca.getBanco();
    }

    public Conta(ContaInvestimento contaInvestimento) {
        this.tipoConta = contaInvestimento.getTipoConta();
        this.numero = contaInvestimento.getNumero();
        this.saldo = contaInvestimento.getSaldo();
        this.limite = contaInvestimento.getLimite();
        this.extrato = contaInvestimento.getExtrato();
        this.banco = contaInvestimento.getBanco();
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

    public List<Transacao> getExtrato() {
        return this.extrato;
    }

    public void setExtrato(List<Transacao> extrato) {
        this.extrato = extrato;
    }

    public String getBanco() {
        return this.banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    private Integer gerarNumero() {
        return this.tipoConta;
    }

    public void registrarTransacao(Transacao transacao) {
        if(transacao.efetuarTransacao()) {
            this.extrato.add(transacao);
            return;
        }

        System.out.println("Transação não é válida");
    }

    public void verSaldo() {
        System.out.println(this.saldo);
    }

    public String toString() {
        return "{ tipoConta: " + this.tipoConta + ", \n" + "numero: " + this.numero + ", \n" + "saldo: " + this.saldo +
                ", \n" + "limite: " + this.limite + ", \n" + "extrato: {" + this.extrato + "}, \n" + "banco: " + this.banco;
    }
}
