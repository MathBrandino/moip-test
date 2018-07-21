package br.com.matheus.moiptest.infra.dao;

import br.com.matheus.moiptest.model.buyer.Buyer;

import java.util.Optional;

import org.springframework.data.repository.Repository;

public interface BuyerDAO extends Repository<Buyer, Long> {
    void save(Buyer buyer);

    Optional<Buyer> findBuyerByCpf(String cpf);
}
