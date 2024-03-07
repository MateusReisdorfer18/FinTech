package br.com.fintech.model.contas;

import br.com.fintech.model.Transacao;

import java.util.ArrayList;
import java.util.List;

public class ContaPoupanca implements IConta{
    private Integer numero;
    private Double saldo;
    private Double limite;
    private List<Transacao> extrato = new ArrayList<>();
    private String banco;

    public ContaPoupanca() {}

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
        return 0;
    }

    @Override
    public void registrarTransacao(Transacao transacao) {

    }

    @Override
    public void verSaldo() {

    }

}
