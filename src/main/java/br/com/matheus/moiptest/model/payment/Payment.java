package br.com.matheus.moiptest.model.payment;

import br.com.matheus.moiptest.model.payment.processes.ResponseProcess;

import java.math.BigDecimal;

public abstract class Payment {

    private BigDecimal amount;


    Payment(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }


    public abstract ResponseProcess process();
}
