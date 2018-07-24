package br.com.matheus.moiptest.model.payment;

import br.com.matheus.moiptest.model.buyer.Buyer;
import br.com.matheus.moiptest.model.client.Client;
import br.com.matheus.moiptest.model.payment.method.PaymentMethod;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private PaymentMethod paymentMethod;

    @ManyToOne
    private Buyer buyer;

    @ManyToOne
    private Client client;


    @Deprecated
    Payment(){}

    public Payment(PaymentMethod paymentMethod, Buyer buyer, Client client) {
        this.paymentMethod = paymentMethod;
        this.buyer = buyer;
        this.client = client;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Client getClient() {
        return client;
    }
}
