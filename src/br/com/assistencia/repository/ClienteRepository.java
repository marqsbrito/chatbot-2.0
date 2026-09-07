package br.com.assistencia.repository;

import br.com.assistencia.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private final List<Cliente> clientes = new ArrayList<>();

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