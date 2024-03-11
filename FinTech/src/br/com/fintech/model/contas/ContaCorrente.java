package br.com.fintech.model.contas;

import java.util.ArrayList;

public class ContaCorrente extends Conta {

    public ContaCorrente(String cliente, int numero) {
        this.setTipoConta(1);
        this.setNumero(this.gerarNumero(numero));
        this.setSaldo(0.0);
        this.setLimite(0.0);
        this.setExtrato(new ArrayList<>());
        this.setBanco("");
        this.setCliente(cliente);
    }
}
