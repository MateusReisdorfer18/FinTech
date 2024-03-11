package br.com.fintech;

import br.com.fintech.model.Acoes;
import br.com.fintech.model.Cliente;
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
                     [3] Entrar em uma conta \s
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
                    int numConta;
                    Integer opcaoMenu;
                    Double valorAcao;

                    System.out.println("Digite o número da sua conta para acessa-la");
                    numConta = scan.nextInt();
                    Conta contaEncontrada = cliente.getContaByNum(numConta);

                    if(contaEncontrada == null) {
                        System.out.printf("Conta não encontrada com o número %d", numConta);
                        break;
                    }

                    do {
                        System.out.println("Menu Conta \n [1] Depositar \n [2] Sacar \n [3] Efetuar Pagamento \n [0] Encerrar");
                        opcaoMenu = scan.nextInt();
                    } while(opcaoMenu > 3);

                    if(opcaoMenu == 0) {
                        System.out.println("Saindo...");
                        break;
                    }

                    switch(opcaoMenu) {
                        case 1:
                            System.out.println("Digite o valor da acao");
                            valorAcao = scan.nextDouble();

                            contaEncontrada.depositar(valorAcao);
                            break;
                        case 2:
                            System.out.println("Digite o valor da acao");
                            valorAcao = scan.nextDouble();

                            contaEncontrada.sacar(valorAcao);
                            break;
                        case 3:
                            Integer tipoAcao;
                            int numDestinatario;
                            Double valor;

                            System.out.println("Digite o tipo do pagamento \n [1] Pix \n [2] TED \n [3] Crédito \n [4] Débito \n [0] Encerrar");
                            tipoAcao = scan.nextInt();

                            if(tipoAcao == 0) {
                                System.out.println("Saindo...");
                                break;
                            }

                            System.out.println("Digite o número da conta do destinatario");
                            numDestinatario = scan.nextInt();

                            Conta destinatario = cliente.getContaByNum(numDestinatario);

                            if(destinatario == null) {
                                System.out.println("A conta do destinatario nao foi encontrada");
                                break;
                            }

                            System.out.println("Digite o valor da ação");
                            valor = scan.nextDouble();

                            Acoes acao = new Acoes(tipoAcao, contaEncontrada, destinatario, valor);

                            acao.efetuarAcao();
                            contaEncontrada.registrarAcao(acao);

                            System.out.println();
                            System.out.println(acao.toString());
                            System.out.println(contaEncontrada.getSaldo());
                            System.out.println(destinatario.getSaldo());
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while(continuar);
    }
}
