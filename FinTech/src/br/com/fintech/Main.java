package br.com.fintech;

import br.com.fintech.model.Cliente;
import br.com.fintech.model.contas.Conta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean continuar = true;

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

                    cliente.criarConta(opcao);

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
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while(continuar);
    }
}
