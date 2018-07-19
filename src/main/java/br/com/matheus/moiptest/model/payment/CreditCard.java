package br.com.matheus.moiptest.model.payment;

import br.com.matheus.moiptest.model.payment.processes.InvalidCardResponseProcess;
import br.com.matheus.moiptest.model.payment.processes.ResponseProcess;
import br.com.matheus.moiptest.model.payment.processes.ValidCardResponseProcess;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class CreditCard extends Payment {

    @Embedded
    private Card card;

    public CreditCard(BigDecimal amount, Card card) {
        super(amount);
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public ResponseProcess process() {

        return card.isValid() ? new ValidCardResponseProcess() : new InvalidCardResponseProcess();
    }
}
