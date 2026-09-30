package br.com.assistencia.model;

public class OrdemServico {

    private Cliente cliente;
    private String problema;
    private String status;
    private String veiculo;

    public OrdemServico(Cliente cliente, String problema, String status, String veiculo) {
        this.cliente = cliente;
        this.problema = problema;
        this.status = status;
        this.veiculo = veiculo;
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
    public String getVeiculo() {
        return veiculo;
    }
}
