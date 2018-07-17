package br.com.matheus.moiptest.model.payment.processes;

public class ValidCardResponseProcess implements ResponseProcess {
    @Override
    public String getResponse() {
        return Boolean.toString(true);
    }
}
