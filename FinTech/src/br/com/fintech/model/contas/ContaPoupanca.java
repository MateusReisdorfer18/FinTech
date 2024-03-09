package br.com.fintech.model.contas;

import br.com.fintech.model.Cliente;
import br.com.fintech.model.Transacao;

import java.util.ArrayList;
import java.util.List;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(String cliente, int numero) {
        this.setTipoConta(2);
        this.setNumero(this.gerarNumero(numero));
        this.setSaldo(0.0);
        this.setLimite(0.0);
        this.setExtrato(new ArrayList<>());
        this.setBanco("");
        this.setCliente(cliente);
    }
}
