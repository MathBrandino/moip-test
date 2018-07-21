package br.com.matheus.moiptest.dto;

import br.com.matheus.moiptest.model.payment.method.PaymentMethodGenerator;
import br.com.matheus.moiptest.model.payment.method.Card;
import br.com.matheus.moiptest.model.payment.method.PaymentMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PaymentMethodDTO {

    @NotNull
    private BigDecimal amount;
    @NotNull
    private String type;
    @Valid
    private Card card;


    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public void setType(String type) {
        this.type = type;
    }


    public void setCard(Card card) {
        this.card = card;
    }

    public PaymentMethod toPaymentMethod() {

        return new PaymentMethodGenerator(type, amount, card).createPaymentMethod();
    }
}
