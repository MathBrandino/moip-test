package br.com.matheus.moiptest.controller;

import br.com.matheus.moiptest.infra.dao.ClientDAO;
import br.com.matheus.moiptest.model.client.Client;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client/")
public class ClientController {

    private ClientDAO clientDAO;

    @Autowired
    public ClientController(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Client client) {

        Client clientSaved = clientDAO.save(client);

        return get(clientSaved.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<Client> client = clientDAO.findClientById(id);

        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado");
    }
}
