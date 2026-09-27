package br.com.assistencia.model;

public class OrdemServico {

    private Cliente cliente;
    private String problema;
    private String status;

    public OrdemServico(Cliente cliente, String problema, String status) {
        this.cliente = cliente;
        this.problema = problema;
        this.status = status;
    }

    //getters


    public Cliente getCliente() {
        return cliente;
    }
    public String getProblema() {
        return problema;
    }
    public String getStatus() {
        return status;
    }
}
