package br.com.matheus.moiptest.model;

import br.com.matheus.moiptest.model.buyer.Buyer;
import br.com.matheus.moiptest.model.client.Client;
import br.com.matheus.moiptest.model.payment.Payment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Payment payment;

    @ManyToOne
    private Buyer buyer;

    @ManyToOne
    private Client client;

    public Sale(Payment payment, Buyer buyer, Client client) {
        this.payment = payment;
        this.buyer = buyer;
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Client getClient() {
        return client;
    }
}
