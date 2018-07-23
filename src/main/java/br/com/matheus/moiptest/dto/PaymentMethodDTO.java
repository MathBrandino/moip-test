package br.com.matheus.moiptest.dto;

import br.com.matheus.moiptest.model.payment.method.Card;
import br.com.matheus.moiptest.model.payment.method.PaymentMethod;
import br.com.matheus.moiptest.model.payment.method.PaymentMethodGenerator;

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


    public PaymentMethodDTO(@NotNull BigDecimal amount, @NotNull String type, @Valid Card card) {
        this.amount = amount;
        this.type = type;
        this.card = card;
    }

    @Deprecated
    PaymentMethodDTO() {
    }

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
