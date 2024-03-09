package br.com.fintech.model;

import br.com.fintech.model.contas.Conta;

public class Transacao {
    private Integer tipo;
    private Conta contaDe;
    private Conta contaPara;
    private Double valor;

    public Transacao(Integer tipo, Conta contaDe, Conta contaPara, Double valor) {
        this.tipo = tipo;
        this.contaDe = contaDe;
        this.contaPara = contaPara;
        this.valor = valor;
    }

    public Integer getTipo() {
        return this.tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Conta getContaDe() {
        return this.contaDe;
    }

    public void setContaDe(Conta contaDe) {
        this.contaDe = contaDe;
    }

    public Conta getContaPara() {
        return this.contaPara;
    }

    public void setContaPara(Conta contaPara) {
        this.contaPara = contaPara;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean efetuarTransacao() {
        if(this.contaDe.getSaldo() >= this.valor) {
            this.contaPara.setSaldo(contaPara.getSaldo() + this.valor);
            this.contaDe.setSaldo(this.contaDe.getSaldo() - this.valor);
            return true;
        }

        return false;
    }

    public String toString() {
        return "Tipo da Transação: " + this.tipo + "\nConta Remetente: " + this.contaDe.getNumero() + "\nConta Destinatario: " + this.contaPara.getNumero() + "\nValor da Transação: " + this.valor;
    }
}
