package br.com.assistencia.repository;

import br.com.assistencia.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {


    private final List<Cliente> clientes = new ArrayList<>();

    public ClienteRepository() {
        Cliente clienteTeste = new Cliente(
                "William",
                "Teste",
                "11999999999",
                "teste@teste.com",
                "1234"

        );
        adicionar(clienteTeste);
    }

    public void adicionar(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarPorCpf(String cpf) {

        for (Cliente cliente : clientes) {

            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        return null;
    }
}