package br.com.matheus.moiptest.model.payment.method;

import br.com.matheus.moiptest.model.payment.processes.ResponseProcess;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal amount;


    PaymentMethod(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }


    public abstract ResponseProcess process();
}