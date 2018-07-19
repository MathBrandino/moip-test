package br.com.matheus.moiptest.model.buyer;

public class Buyer {

    private String name;
    private String cpf;
    private String email;

    public Buyer(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }
}
