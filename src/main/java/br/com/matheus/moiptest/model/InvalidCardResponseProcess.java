package br.com.matheus.moiptest.model;

public class InvalidCardResponseProcess implements ResponseProcess {
    @Override
    public String getResponse() {
        return Boolean.toString(false);
    }
}
