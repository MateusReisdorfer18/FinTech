package br.com.fintech;

import br.com.fintech.model.Cliente;
import br.com.fintech.model.Transacao;
import br.com.fintech.model.contas.Conta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean continuar = true;
        int cont = 0;

        Cliente cliente = new Cliente("Mateus", "mateus@email.com", "06765324976");

        do {
            int opcao;

            System.out.println("Selecione uma opção: \n [1] Criar Conta \n [2] Excluir Conta \n [3] Efetuar Transação \n [0] Sair");
            opcao = scan.nextInt();

            if(opcao == 0) {
                System.out.println("Saindo...");
                continuar = !continuar;
                break;
            }

            switch(opcao) {
                case 1:
                    int opcaoCriar;

                    System.out.println("Selecione o tipo da sua conta : \n [1] Corrente \n [2] Poupança \n [3] Investimento \n [0] Encerrar");
                    opcaoCriar = scan.nextInt();

                    if(opcaoCriar == 0) {
                        System.out.println("Saindo...");
                        break;
                    }

                    cont++;

                    cliente.criarConta(opcaoCriar, cont);

                    for(Conta conta:cliente.getContas()) {
                        System.out.println(conta.toString());
                    }
                    break;
                case 2:
                    int opcaoExcluir;

                    System.out.println("Selecione o tipo da conta que deseja remover : \n [1] Corrente \n [2] Poupança \n [3] Investimento \n [0] Encerrar");
                    opcaoExcluir = scan.nextInt();

                    if(opcaoExcluir == 0) {
                        System.out.println("Saindo...");
                        break;
                    }

                    cliente.encerrarConta(opcaoExcluir);
                    for(Conta conta:cliente.getContas()) {
                        System.out.println(conta.toString());
                    }
                    break;
                case 3:
                    Integer tipoTransacao;
                    int numContaDe;
                    int numContaPara;
                    Double valor;
                    boolean continuarTransacao = false;

                    do {
                        System.out.println("Digite o tipo da transação [1] pix \n [2] TED");
                        tipoTransacao = scan.nextInt();

                        if(tipoTransacao == 1 || tipoTransacao == 2) {
                            continuarTransacao = !continuarTransacao;
                            break;
                        }
                        System.out.println("Opção inválida, digite novamente o tipo da transação");
                    } while(!continuarTransacao);

                    System.out.println("Digite o número da conta do remetente :");
                    numContaDe = scan.nextInt();

                    System.out.println("Digite o número da conta do destinatario :");
                    numContaPara = scan.nextInt();

                    System.out.println("Digite o valor da transação :");
                    valor = scan.nextDouble();

                    Conta contaDe = cliente.getContaByNum(numContaDe);
                    Conta contaPara = cliente.getContaByNum(numContaPara);

                    if(!(contaDe != null && contaPara != null)) {
                        System.out.println("Uma das contas não é válida, verifique e tente novamente");
                        break;
                    }

                    Transacao transacao = new Transacao(tipoTransacao, contaDe, contaPara, valor);

                    if(!transacao.efetuarTransacao()) {
                        System.out.println("A transação é inválida");
                        break;
                    }

                    contaDe.registrarTransacao(transacao);
                    contaPara.registrarTransacao(transacao);

                    System.out.println(contaDe);
                    System.out.println(contaPara);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while(continuar);
    }
}
