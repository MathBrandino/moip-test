package br.com.matheus.moiptest.model.payment.method;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CardTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    private String name;
    private Long number;
    private LocalDate today;
    private Integer cvv;


    @Before
    public void setUp() {
        name = "Matheus";
        number = 123L;
        today = LocalDate.now();
        cvv = 123;
    }

    @Test
    public void shouldIsValidWhenExpirationDateYetValidInLimit() {

        Card card = new Card(name, number, today, cvv);

        Assert.assertTrue(card.isValid());
    }

    @Test
    public void shouldIsValidWhenExpirationDateIsInNextYear() {

        LocalDate nextYear = today.plusYears(1);
        Card card = new Card(name, number, nextYear, cvv);

        Assert.assertTrue(card.isValid());
    }


    @Test
    public void shouldIsInvalidWhenExpirationDateHasExpired() {

        LocalDate yesterday = today.minusDays(1);
        Card card = new Card(name, number, yesterday, cvv);

        Assert.assertFalse(card.isValid());
    }


    @Test
    public void shouldCrashWhenCvvIsNotInsideInRangePositiveInLimit() {

        thrown.expect(IllegalArgumentException.class);

        new Card(name, number, today, 1000);


    }


    @Test
    public void shouldCrashWhenCvvIsNotInsideInRangePositive() {

        thrown.expect(IllegalArgumentException.class);

        new Card(name, number, today, 100000);

    }

    @Test
    public void shouldCrashWhenCvvIsNotInsideInRangeNegative() {

        thrown.expect(IllegalArgumentException.class);

        new Card(name, number, today, -1000);

    }


    @Test
    public void shouldCrashWhenCvvIsNotInsideInRangeNegativeInLimit() {

        thrown.expect(IllegalArgumentException.class);

        new Card(name, number, today, 0);

    }

}
