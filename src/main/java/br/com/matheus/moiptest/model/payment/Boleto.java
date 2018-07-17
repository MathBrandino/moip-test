package br.com.matheus.moiptest.model.payment;

import br.com.matheus.moiptest.model.payment.processes.BoletoResponseProcess;
import br.com.matheus.moiptest.model.payment.processes.ResponseProcess;

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
