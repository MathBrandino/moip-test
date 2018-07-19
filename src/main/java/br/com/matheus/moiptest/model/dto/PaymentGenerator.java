package br.com.matheus.moiptest.model.dto;

import br.com.matheus.moiptest.model.payment.Card;
import br.com.matheus.moiptest.model.payment.Payment;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

class PaymentGenerator {
    private static final String PACKAGE = "br.com.matheus.moiptest.model.payment.";
    private final String type;
    private final BigDecimal amount;
    private final Card card;

    PaymentGenerator(String type, BigDecimal amount, Card card) {
        this.type = type;
        this.amount = amount;
        this.card = card;
    }

    Payment createPayment() {
        try {

            Class<Payment> clazz = (Class<Payment>) Class.forName(PACKAGE + type);
            Payment payment;
            if (type.equals("Boleto")) {
                Constructor<Payment> constructor = clazz.getConstructor(BigDecimal.class);
                payment = constructor.newInstance(amount);
            } else {
                Constructor<Payment> constructor = clazz.getConstructor(BigDecimal.class, Card.class);
                payment = constructor.newInstance(amount, card);
            }
            return payment;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
