package br.com.matheus.moiptest.model;

import java.math.BigDecimal;

public class Boleto extends Payment {

    public Boleto(BigDecimal amount) {
        super(amount, PaymentType.BOLETO);
    }

    @Override
    public ResponseProcess process() {
        return new BoletoResponseProcess();
    }
}
