package br.com.fintech.model.contas;

import br.com.fintech.model.Cliente;
import br.com.fintech.model.Transacao;
import java.util.List;

public class Conta {
    private Integer tipoConta;
    private Integer numero;
    private Double saldo;
    private Double limite;
    private List<Transacao> extrato;
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

    public String getCliente() {
        return this.cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer gerarNumero(int cont) {
        return cont;
    }

    public void registrarTransacao(Transacao transacao) {
        this.extrato.add(transacao);
    }

    public void verSaldo() {
        System.out.println(this.saldo);
    }

    public String toString() {
        return "{ tipoConta: " + this.tipoConta + ", \n" + "numero: " + this.numero + ", \n" + "saldo: " + this.saldo +
                ", \n" + "limite: " + this.limite + ", \n" + "extrato: {" + this.extrato + "}, \n" + "banco: " + this.banco +
                ", \n" + "cliente: " + this.cliente;
    }
}
