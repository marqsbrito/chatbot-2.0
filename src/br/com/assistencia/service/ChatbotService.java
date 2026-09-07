package br.com.assistencia.service;

import br.com.assistencia.model.Cliente;
import br.com.assistencia.repository.ClienteRepository;

import java.util.Scanner;

public class ChatbotService {

    private final Scanner scanner;
    private final ClienteRepository repository;

    public ChatbotService() {
        scanner = new Scanner(System.in);
        repository = new ClienteRepository();
    }
    //cod inicial
    public void iniciar() {

        boolean continuar = true;

        while (continuar) {

            System.out.println("Olá! Sou o assistente da AutoTech.");
            System.out.println("Você já é nosso cliente?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            String resposta = scanner.nextLine();

            if (resposta.equals("1")) {

                System.out.println("Digite seu CPF:");
                String cpf = scanner.nextLine();

                Cliente cliente = repository.buscarPorCpf(cpf);

                if (cliente != null) {
                    System.out.println("Olá, " + cliente.getPrimeiroNome() + "!");
                } else {
                    System.out.println("CPF não encontrado no sistema.");
                }

            } else if (resposta.equals("2")) {

                cadastrarCliente();

            } else {

                System.out.println("Opção inválida.");
            }

            System.out.println();
            System.out.println("Deseja continuar?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            String continuarResposta = scanner.nextLine();

            if (continuarResposta.equals("2")) {
                continuar = false;
            }
        }
    }

    //cadastro de cliente- as perguntas estao meio secas,preciso melhorar
    private void cadastrarCliente() {

        System.out.println("Vamos fazer seu cadastro.");

        System.out.println("Digite seu primeiro nome:");
        String primeiroNome = scanner.nextLine();

        System.out.println("Digite seu sobrenome:");
        String sobrenome = scanner.nextLine();

        System.out.println("Digite seu CPF:");
        String cpf = scanner.nextLine();

        System.out.println("Digite seu telefone:");
        String telefone = scanner.nextLine();

        System.out.println("Digite seu e-mail:");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente(
                primeiroNome,
                sobrenome,
                telefone,
                email,
                cpf
        );

        repository.adicionar(cliente);

        System.out.println("Cadastro realizado com sucesso!");
        System.out.println("Seu ID de cliente é: " + cliente.getId());
    }
}