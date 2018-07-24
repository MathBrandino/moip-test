package br.com.matheus.moiptest.model.payment.method;

import br.com.matheus.moiptest.model.payment.processes.ResponseProcess;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(1)
    private BigDecimal amount;


    @Deprecated
    PaymentMethod() {
    }

    PaymentMethod(BigDecimal amount) {
        if (amount == null) throw new IllegalArgumentException("Valor não deve ser nulo");
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Valor deve ser maior que zero");

        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }


    public abstract ResponseProcess process();
}
