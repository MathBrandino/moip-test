package br.com.matheus.moiptest.model.client;

public class Client {

    private Long id;
    private String name;

    @Deprecated
    Client() {

    }

    public Client(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Deprecated
    public void setId(Long id) {
        this.id = id;
    }

    @Deprecated
    public void setName(String name) {
        this.name = name;
    }
}
