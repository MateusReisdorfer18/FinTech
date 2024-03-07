package br.com.fintech.model;

import br.com.fintech.model.contas.IConta;

public class Transacao {
    private Integer tipo;
    private IConta contaDe;
    private IConta contaPara;
    private Double valor;

    public Transacao() {}

    public Integer getTipo() {
        return this.tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public IConta getContaDe() {
        return this.contaDe;
    }

    public void setContaDe(IConta contaDe) {
        this.contaDe = contaDe;
    }

    public IConta getContaPara() {
        return this.contaPara;
    }

    public void setContaPara(IConta contaPara) {
        this.contaPara = contaPara;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean efetuarTransacao() {
        return false;
    }
}
