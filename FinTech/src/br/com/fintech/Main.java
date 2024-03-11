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

            System.out.println("""
                    Selecione uma opção:\s
                     [1] Criar Conta\s
                     [2] Excluir Conta\s
                     [3] Efetuar Transação\s
                     [4] Entrar em uma conta \s
                     [0] Sair""");
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

                    transacao.efetuarTransacao(tipoTransacao);

                    contaDe.registrarTransacao(transacao);
                    contaPara.registrarTransacao(transacao);
                    break;
                case 4:
                    int numConta;

                    System.out.println("Digite o número da sua conta para acessa-la");
                    numConta = scan.nextInt();

                    Conta contaEncontrada = cliente.getContaByNum(numConta);

                    Integer opcaoMenu;

                    do {
                        System.out.println("Menu Conta \n [1] Depositar \n 2 [Sacar] \n [0] Encerrar");
                        opcaoMenu = scan.nextInt();
                    } while(opcaoMenu > 2);

                    if(opcaoMenu == 0) {
                        System.out.println("Saindo...");
                        break;
                    }

                    Double valorAcao;

                    System.out.println("Digite o valor da acao");
                    valorAcao = scan.nextDouble();

                    contaEncontrada.acoes(opcaoMenu, valorAcao);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while(continuar);
    }
}
