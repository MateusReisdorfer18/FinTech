package br.com.fintech.model.contas;

import br.com.fintech.model.Transacao;

import java.util.ArrayList;
import java.util.List;

public class ContaInvestimento implements IConta {
    private Integer numero;
    private Double saldo;
    private Double limite;
    private List<Transacao> extrato = new ArrayList<>();
    private String banco;

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
