package br.com.matheus.moiptest.infra.dao;

import br.com.matheus.moiptest.model.payment.method.PaymentMethod;

import org.springframework.data.repository.Repository;

public interface PaymentMethodDAO extends Repository<PaymentMethod, Long> {
    void save(PaymentMethod paymentMethod);
}
