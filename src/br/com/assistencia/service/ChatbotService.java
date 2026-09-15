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

        System.out.println("Olá! Sou o assistente da AutoTech.");
        System.out.println("Você já é um de nossos clientes ?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");

        String resposta = scanner.nextLine();

        Cliente clienteAtual = null;

        if (resposta.equals("1")) {

            System.out.println("Digite seu CPF:");
            String cpf = scanner.nextLine();

            clienteAtual = repository.buscarPorCpf(cpf);

            if (clienteAtual != null) {

                System.out.println("Olá, " + clienteAtual.getPrimeiroNome() + "!");
                menuPrincipal(clienteAtual);

            } else {

                System.out.println("CPF não encontrado no sistema.");
            }

        } else if (resposta.equals("2")) {

            System.out.println("Você gostaria de realizar seu cadastro?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            String cadastrar = scanner.nextLine();

            if (cadastrar.equals("1")) {

                clienteAtual = cadastrarCliente();

                System.out.println();
                System.out.println("Deseja ir para o menu?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");

                String irParaMenu = scanner.nextLine();

                if (irParaMenu.equals("1")) {
                    menuPrincipal(clienteAtual);
                }

            } else {

                System.out.println("Tudo bem. Quando precisar, estaremos à disposição.");
            }

        } else {

            System.out.println("Opção inválida.");
        }
    }

//Menu principal

    private void menuPrincipal(Cliente cliente) {
        boolean continuarMenu = true;

        while (continuarMenu) {
            System.out.println();
            System.out.println("Como posso ajudar, " + cliente.getPrimeiroNome() + "?");
            System.out.println();
            System.out.println("1- Solicitar assistência técnica");
            System.out.println("2- Consultar ordem de serviço");
            System.out.println("3- Consultar histórico");
            System.out.println("4- Meus Dados");
            System.out.println("5- Sair");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Solicitar assistência técnica.");
                    break;

                case "2":
                    System.out.println("Consultar ordem de serviço.");
                    break;

                case "3":
                    System.out.println("Consultar histórico.");
                    break;

                case "4":
                    System.out.println("Meus Dados.");
                    break;

                case "5":
                    System.out.println("Ok, lembre-se: se precisar de alguma ajuda é só me procurar! Thcau Tchau :)");
                    System.out.println("Saindo...");
                    continuarMenu = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        }
    }

    //cadastro de cliente
    private Cliente cadastrarCliente() {

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

        return cliente;
    }
}

