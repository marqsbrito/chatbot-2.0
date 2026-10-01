package br.com.assistencia.service;

import br.com.assistencia.model.Cliente;
import br.com.assistencia.model.OrdemServico;
import br.com.assistencia.repository.ClienteRepository;

//bibliotecas
import java.util.ArrayList;
import java.util.List;
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

        Cliente clienteAtual;

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
        OrdemServico ordemServico = null;
        boolean continuarMenu = true;
        List<OrdemServico> historico = new ArrayList<>();

        while (continuarMenu) {
            System.out.println();
            System.out.println("Como posso ajudar, " + cliente.getPrimeiroNome() + "?");
            System.out.println();
            System.out.println("1- Solicitar serviço");
            System.out.println("2- Consultar ordem de serviço");
            System.out.println("3- Consultar histórico");
            System.out.println("4- Meus Dados");
            System.out.println("5- Sair");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    String servico = "";
                    boolean escolherServico = true;
                    while (escolherServico) {

                        System.out.println();
                        System.out.println("Qual serviço você deseja solicitar?");
                        System.out.println();
                        System.out.println("1- Troca de óleo");
                        System.out.println("2- Revisão");
                        System.out.println("3- Troca de pneus");
                        System.out.println("4- Problema no motor");
                        System.out.println("5- Volar");

                        String opcaoServico = scanner.nextLine();

                        switch (opcaoServico) {
                            case "1":
                                servico = "Troca de óleo";
                                escolherServico = false;
                                break;
                            case "2":
                                servico = "Revisão";
                                escolherServico = false;
                                break;
                            case "3":
                                servico = "Troca de pneus";
                                escolherServico = false;
                                break;
                            case "4":
                                servico = "Problema no motor";
                                escolherServico = false;
                                break;
                            case "5":
                                System.out.println("Voltando ao menu principal...");
                                escolherServico = false;
                                break;
                            default:
                                System.out.println("Opão inválida!");
                                break;
                        }

                        if (!servico.isEmpty()){

                            System.out.println();
                            System.out.println("Para qual veículo será o(s) serviço(s) respectivamente?");
                            System.out.println("Digite o modelo do veículo:");
                            String modelo = scanner.nextLine();

                            System.out.println("Digete a placa do veículo:");
                            String placa = scanner.nextLine();

                            String veiculo = modelo + "-" + placa;

                            ordemServico = new OrdemServico(
                                    cliente,
                                    servico,
                                    "Aberta",
                                    veiculo
                            );
                            historico.add(ordemServico);
                            System.out.println();
                            System.out.println("Serviço selecionado:" + servico);
                            System.out.println("Veículo: " + veiculo);
                            System.out.println("Sua solicitação foi registrada com sucesso!");

                        }
                    }
                    break;

                case "2":
                    if (ordemServico != null) {

                        System.out.println();
                        System.out.println("Sua ordem de serviço:");
                        System.out.println("Serviço: " + ordemServico.getProblema());
                        System.out.println("Veículo: " + ordemServico.getVeiculo());
                        System.out.println("Status: " + ordemServico.getStatus());

                    } else {

                        System.out.println();
                        System.out.println("Você ainda não possui nenhuma ordem de serviço.");
                    }

                    break;

                case "3":
                    consultarHistorico(historico);
                    break;

                case "4":
                    System.out.println("Meus Dados:");
                    System.out.println();
                    System.out.println("Nome: " + cliente.getPrimeiroNome() + " " + cliente.getSobrenome());
                    System.out.println("CPF: " + cliente.getCpf());
                    System.out.println("Telefone: " + cliente.getTelefone());
                    System.out.println("Email: " + cliente.getEmail());

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

    //Histórico do cliente
    private void consultarHistorico(List<OrdemServico> historico) {

        if (historico.isEmpty()) {

            System.out.println();
            System.out.println("Você ainda não possui um histórico de serviços disponível.");

        } else {

            System.out.println();
            System.out.println("Aqui está o histórico de serviços:");

            for (OrdemServico ordem : historico) {

                System.out.println();
                System.out.println("Veículo: " + ordem.getVeiculo());
                System.out.println("Serviço: " + ordem.getProblema());
                System.out.println("Status: " + ordem.getStatus());
            }
        }
    }
}


