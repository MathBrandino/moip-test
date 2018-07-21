package br.com.matheus.moiptest.infra.dao;

import br.com.matheus.moiptest.model.client.Client;

import java.util.Optional;

import org.springframework.data.repository.Repository;

public interface ClientDAO extends Repository<Client, Long> {
    Client save(Client client);

    Optional<Client> findClientById(Long id);
}
