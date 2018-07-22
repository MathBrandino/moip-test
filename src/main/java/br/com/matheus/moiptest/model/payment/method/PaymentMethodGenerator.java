package br.com.matheus.moiptest.model.payment.method;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public class PaymentMethodGenerator {
    private static final String PACKAGE = "br.com.matheus.moiptest.model.payment.method.";
    private final String type;
    private final BigDecimal amount;
    private final Card card;

    public PaymentMethodGenerator(String type, BigDecimal amount, Card card) {
        this.type = type;
        this.amount = amount;
        this.card = card;
    }

    public PaymentMethod createPaymentMethod() {
        try {

            Class<PaymentMethod> clazz = (Class<PaymentMethod>) Class.forName(PACKAGE + type);
            PaymentMethod paymentMethod;
            if (type.equals("Boleto")) {
                Constructor<PaymentMethod> constructor = clazz.getConstructor(BigDecimal.class);
                paymentMethod = constructor.newInstance(amount);
            } else {
                Constructor<PaymentMethod> constructor = clazz.getConstructor(BigDecimal.class, Card.class);
                paymentMethod = constructor.newInstance(amount, card);
            }
            return paymentMethod;
        } catch (InstantiationException e) {
        } catch (InvocationTargetException e) {
        } catch (NoSuchMethodException e) {
        } catch (IllegalAccessException e) {
        } catch (ClassNotFoundException e) {
        }

        return null;
    }
}
