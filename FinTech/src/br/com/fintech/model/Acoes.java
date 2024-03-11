package br.com.fintech.model;

import br.com.fintech.model.contas.Conta;

public class Acoes {
    private Integer tipoAcao;
    private Conta remetente;
    private Conta destinatario;
    private Double valor;

    public Acoes(Integer tipoAcao, Conta remetente, Conta destinatario, Double valor) {
        this.tipoAcao = tipoAcao;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.valor = valor;
    }

    public Integer getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(Integer tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public Conta getRemetente() {
        return this.remetente;
    }

    public void setRemetente(Conta remetente) {
        this.remetente = remetente;
    }

    public Conta getDestinatario() {
        return this.destinatario;
    }

    public void setDestinatario(Conta destinatario) {
        this.destinatario = destinatario;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void efetuarAcao() {
        switch(this.tipoAcao) {
            case 1:
                this.pagamentoPix();
                break;
            case 2:
                this.pagamentoTED();
                break;
            case 3:
                this.pagamentoCredito();
                break;
            case 4:
                this.pagamentoDebito();
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private void pagamentoPix() {
        if(!this.consultarValor()) {
            System.out.println("Saldo insufisciente");
            return;
        }

        this.remetente.setSaldo(this.remetente.getSaldo() - this.valor);
        this.destinatario.setSaldo(this.destinatario.getSaldo() + this.valor);
        System.out.printf("Pagamento efetuado no pix no valor de R$%f", this.valor);
    }

    private void pagamentoTED() {
        if(!this.consultarValor()) {
            System.out.println("Saldo insufisciente");
            return;
        }

        Integer taxaTED = 20;
        if(!this.consultarValorComTaxa(taxaTED, this.tipoAcao)) {
            System.out.println("Não e possivel concluir a transacao pois o saldo do remetente e insufisciente");
            return;
        }

        this.remetente.setSaldo(this.remetente.getSaldo() - (this.valor + taxaTED));
        this.destinatario.setSaldo(this.destinatario.getSaldo() + this.valor);
        System.out.printf("Transação efetuada no TED no valor de R$%f", this.valor);
    }

    private void pagamentoCredito() {
        if(!this.consultarValor()) {
            System.out.println("Saldo insufisciente");
            return;
        }

        Integer taxa = 1;
        if(!this.consultarValorComTaxa(taxa, this.tipoAcao)) {
            System.out.println("Saldo insufisciente para o pagamento");
            return;
        }

        this.remetente.setSaldo(this.remetente.getSaldo() - this.calcularTaxaCredito(taxa, this.valor));
        this.destinatario.setSaldo(this.destinatario.getSaldo() + this.valor);
        System.out.printf("Pagamento efetuado no crédito no valor de R$%f", this.valor);
    }

    private void pagamentoDebito() {
        if(!this.consultarValor()) {
            System.out.println("Saldo insufisciente");
            return;
        }

        this.remetente.setSaldo(this.remetente.getSaldo() - this.valor);
        this.destinatario.setSaldo(this.destinatario.getSaldo() + this.valor);
        System.out.printf("Pagamento efetuado no débito no valor de R$%f", this.valor);
    }

    private Double calcularTaxaCredito(Integer taxa, Double valor) {
        return (taxa / valor) * 100;
    }

    private boolean consultarValor() {
        return this.valor > 0;
    }

    private boolean consultarValorComTaxa(Integer taxa, Integer tipoAcao) {
        if(tipoAcao == 2) {
            return this.valor + taxa > taxa;
        }

        return this.valor > this.calcularTaxaCredito(taxa, this.valor);
    }

    public String toString() {
        return "{tipoAcao: " + this.tipoAcao + ", \n" + "Conta do remetente: " + this.remetente.getNumero() + ", \n"
                + "Conta do destinatario: " + this.destinatario.getNumero() + ", \n" + "valor: " + this.valor;
    }
}
