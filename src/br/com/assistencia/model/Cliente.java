package br.com.assistencia.model;

public class Cliente {

    private static int proximoId = 1;

    private final int id;
    private final String cpf;

    private String primeiroNome;
    private String sobrenome;
    private String telefone;
    private String email;
    //Construtor
    public Cliente(String primeiroNome,
                   String sobrenome,
                   String telefone,
                   String email,
                   String cpf) {

        this.id = proximoId++;
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }
    //getters e setters
    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}