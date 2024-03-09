package br.com.fintech.model.contas;

import br.com.fintech.model.Cliente;
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
    private String cliente;

    public ContaInvestimento(String cliente, int numero) {
        this.setTipoConta(3);
        this.setNumero(this.gerarNumero(numero));
        this.setSaldo(0.0);
        this.setLimite(0.0);
        this.setExtrato(new ArrayList<>());
        this.setBanco("");
        this.setCliente(cliente);
    }
}
