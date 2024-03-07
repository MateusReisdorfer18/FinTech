package br.com.fintech.model.contas;

import br.com.fintech.model.Transacao;

import java.util.ArrayList;
import java.util.List;

public interface IConta {
    Integer numero = 0;
    Double saldo = 0.0;
    Double limite = 0.0;
    List<Transacao> extrato = new ArrayList<>();
    String banco = "";

    private Integer gerarNumero() {
        return 0;
    }
    void registrarTransacao(Transacao transacao);
    void verSaldo();
}
