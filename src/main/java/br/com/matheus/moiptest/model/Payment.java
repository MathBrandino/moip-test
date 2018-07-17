package br.com.matheus.moiptest.model;

import java.math.BigDecimal;

public abstract class Payment {

    private BigDecimal amount;
    private PaymentType type;


    Payment(BigDecimal amount, PaymentType type) {
        this.amount = amount;
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }


    public PaymentType getType() {
        return type;
    }

    public abstract ResponseProcess process();
}
