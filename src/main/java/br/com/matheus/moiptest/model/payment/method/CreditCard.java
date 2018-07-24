package br.com.matheus.moiptest.model.payment.method;

import br.com.matheus.moiptest.model.payment.processes.InvalidCardResponseProcess;
import br.com.matheus.moiptest.model.payment.processes.ResponseProcess;
import br.com.matheus.moiptest.model.payment.processes.ValidCardResponseProcess;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class CreditCard extends PaymentMethod {

    @Embedded
    private Card card;

    @Deprecated
    CreditCard() {

    }

    public CreditCard(BigDecimal amount, Card card) {
        super(amount);
        if (card == null) throw new IllegalArgumentException("O cartão precisa ser passado");
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
