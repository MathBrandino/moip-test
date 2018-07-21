package br.com.matheus.moiptest.infra.dao;

import br.com.matheus.moiptest.model.payment.Payment;

import org.springframework.data.repository.Repository;

public interface PaymentDAO extends Repository<Payment, Long> {
    void save(Payment payment);
}
