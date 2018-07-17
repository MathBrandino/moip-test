package br.com.matheus.moiptest.model.payment;

import java.math.BigDecimal;

import org.springframework.lang.Nullable;

public enum PaymentType {
    CARD {
        @Override
        public Payment createPayment(BigDecimal amount, Card card) {
            return new CreditCard(amount, card);
        }
    }, BOLETO {
        @Override
        public Payment createPayment(BigDecimal amount, Card card) {
            return new Boleto(amount);
        }
    };

    public abstract Payment createPayment(BigDecimal amount, @Nullable Card card);
}
