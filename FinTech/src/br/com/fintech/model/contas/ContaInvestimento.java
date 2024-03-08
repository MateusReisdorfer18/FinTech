package br.com.fintech.model.contas;

import br.com.fintech.model.Transacao;

import java.util.ArrayList;
import java.util.List;

public class ContaInvestimento extends Conta {
    private Integer tipoConta;
    private Integer numero;
    private Double saldo;
    private Double limite;
    private List<Transacao> extrato = new ArrayList<>();
    private String banco;

    public ContaInvestimento() {
        this.tipoConta = 3;
        this.numero = this.gerarNumero();
        this.saldo = 0.0;
        this.limite = 0.0;
        this.extrato = new ArrayList<>();
        this.banco = "";
    }

    @Override
    public Integer getTipoConta() {
        return this.tipoConta;
    }

    @Override
    public void setTipoConta(Integer tipoConta) {
        this.tipoConta = tipoConta;
    }

    @Override
    public Integer getNumero() {
        return this.numero;
    }

    @Override
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public Double getSaldo() {
        return this.saldo;
    }

    @Override
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public Double getLimite() {
        return this.limite;
    }

    @Override
    public void setLimite(Double limite) {
        this.limite = limite;
    }

    @Override
    public List<Transacao> getExtrato() {
        return this.extrato;
    }

    @Override
    public void setExtrato(List<Transacao> extrato) {
        this.extrato = extrato;
    }

    @Override
    public String getBanco() {
        return this.banco;
    }

    @Override
    public void setBanco(String banco) {
        this.banco = banco;
    }

    private Integer gerarNumero() {
        return this.tipoConta;
    }

    @Override
    public void registrarTransacao(Transacao transacao) {

    }

    @Override
    public void verSaldo() {
        System.out.println(this.saldo);
    }
    @Override
    public String toString() {
        return "{ tipoConta: " + this.tipoConta + ", \n" + "numero: " + this.numero + ", \n" + "saldo: " + this.saldo +
                ", \n" + "limite: " + this.limite + ", \n" + "extrato: {" + this.extrato + "}, \n" + "banco: " + this.banco;
    }
}
