package br.com.matheus.moiptest.model.payment.method;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class PaymentMethodGeneratorTest {


    private String boleto;
    private String creditCard;
    private BigDecimal amount;
    private Card card;


    @Before
    public void setUp() {
        boleto = "Boleto";
        creditCard = "CreditCard";
        amount = BigDecimal.ONE;
        card = new Card("Matheus", 1L, LocalDate.now(), 123);

    }

    @Test
    public void shouldReturnAnInstanceOffBoleto() {
        PaymentMethodGenerator generator = new PaymentMethodGenerator(boleto, amount, null);

        PaymentMethod paymentMethod = generator.createPaymentMethod();

        assertTrue(paymentMethod instanceof Boleto);

    }

    @Test
    public void shouldReturnAnInstanceOffCreditCard() {
        PaymentMethodGenerator generator = new PaymentMethodGenerator(creditCard, amount, card);

        PaymentMethod paymentMethod = generator.createPaymentMethod();

        assertTrue(paymentMethod instanceof CreditCard);

    }

    @Test
    public void shouldReturnNullWhenTypeIsNotAPaymentMethod() {
        PaymentMethodGenerator generator = new PaymentMethodGenerator("ABC", amount, null);

        PaymentMethod paymentMethod = generator.createPaymentMethod();

        assertNull(paymentMethod);
    }
}
