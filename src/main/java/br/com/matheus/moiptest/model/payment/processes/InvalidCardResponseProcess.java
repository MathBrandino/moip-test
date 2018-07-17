package br.com.matheus.moiptest.model.payment.processes;

public class InvalidCardResponseProcess implements ResponseProcess {
    @Override
    public String getResponse() {
        return Boolean.toString(false);
    }
}
