package br.com.matheus.moiptest.model.payment.method;

import br.com.matheus.moiptest.infra.LocalDateJsonConfigurator;

import javax.persistence.Embeddable;
import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Embeddable
public class Card {

    private String name;
    private Long number;

    @JsonDeserialize(using = LocalDateJsonConfigurator.LocalDateDeserializer.class)
    private LocalDate expirationDate;

    @Range(min = 1, max = 999, message = "CVV inválido")
    private Integer cvv;


    @Deprecated
    Card() {

    }

    Card(String name, Long number, LocalDate expirationDate, Integer cvv) {

        if (cvv <= 0 || cvv >= 1000) throw new IllegalArgumentException("CVV inválido");

        this.name = name;
        this.number = number;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public String getName() {
        return name;
    }

    public Long getNumber() {
        return number;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public Integer getCvv() {
        return cvv;
    }

    @Deprecated
    public void setName(String name) {
        this.name = name;
    }

    @Deprecated
    public void setNumber(Long number) {
        this.number = number;
    }

    @Deprecated
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Deprecated
    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public boolean isValid() {
        LocalDate today = LocalDate.now();
        return expirationDate.isAfter(today) || expirationDate.isEqual(today);
    }
}
