package br.com.matheus.moiptest.model.payment.method;

import br.com.matheus.moiptest.model.payment.processes.BoletoResponseProcess;
import br.com.matheus.moiptest.model.payment.processes.ResponseProcess;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Boleto extends PaymentMethod {

    @Deprecated
    Boleto() {
    }

    public Boleto(BigDecimal amount) {
        super(amount);
    }

    @Override
    public ResponseProcess process() {
        return new BoletoResponseProcess();
    }
}
