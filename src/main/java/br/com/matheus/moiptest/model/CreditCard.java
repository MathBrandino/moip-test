package br.com.matheus.moiptest.model;

import java.math.BigDecimal;

public class CreditCard extends Payment {


    private Card card;

    public CreditCard(BigDecimal amount, Card card) {
        super(amount, PaymentType.CARD);
        this.card = card;
    }

    public Card getCard() {
        return card;
    }
}
