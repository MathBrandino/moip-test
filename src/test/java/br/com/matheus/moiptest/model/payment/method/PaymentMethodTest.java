package br.com.matheus.moiptest.model.payment.method;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PaymentMethodTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    private BigDecimal amountValid;
    private BigDecimal amountInvalid;
    private BigDecimal zero;
    private String name;
    private Long number;
    private LocalDate today;
    private Integer cvv;

    @Before
    public void setUp() {
        amountValid = new BigDecimal(100.00);
        amountInvalid = new BigDecimal(-100.00);
        zero = BigDecimal.ZERO;
        name = "Matheus";
        number = 1234L;
        today = LocalDate.now();
        cvv = 123;
    }


    @Test
    public void shouldShowNegativeResponseWhenCreditCardIsInvalid() {
        LocalDate yesterday = today.minusDays(1);

        Card card = new Card(name, number, yesterday, cvv);
        CreditCard creditCard = new CreditCard(amountValid, card);

        String response = creditCard.process().getResponse();

        assertEquals("false", response);
    }


    @Test
    public void shouldShowPositiveResponseWhenCreditCardIsValidInLimit() {

        Card card = new Card(name, number, today, cvv);
        CreditCard creditCard = new CreditCard(amountValid, card);

        String response = creditCard.process().getResponse();

        assertEquals("true", response);
    }


    @Test
    public void shouldShowPositiveResponseWhenCreditCardIsValid() {

        LocalDate tomorrow = today.plusDays(1);
        Card card = new Card(name, number, tomorrow, cvv);
        CreditCard creditCard = new CreditCard(amountValid, card);

        String response = creditCard.process().getResponse();

        assertEquals("true", response);
    }


    @Test
    public void shouldShowSomeNumberResponseWhenPaymentMethodIsBoleto() {

        Boleto boleto = new Boleto(amountValid);
        String response = boleto.process().getResponse();

        assertEquals(Integer.class, Integer.valueOf(response).getClass());
    }


    @Test
    public void shouldCrashWhenAmountIsNull() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Valor não deve ser nulo");

        new Boleto(null);

    }

    @Test
    public void shouldCrashWhenAmountIsInvalid() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Valor deve ser maior que zero");

        new Boleto(amountInvalid);
    }


    @Test
    public void shouldCrashWhenAmountIsInvalidInLimit() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Valor deve ser maior que zero");

        new Boleto(zero);
    }


    @Test
    public void shouldCrashWhenCardIsNotPassed() {

        thrown.expect(IllegalArgumentException.class);

        new CreditCard(zero, null);
    }


}
