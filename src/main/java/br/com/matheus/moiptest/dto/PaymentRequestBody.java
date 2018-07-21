package br.com.matheus.moiptest.dto;

import br.com.matheus.moiptest.model.buyer.Buyer;
import br.com.matheus.moiptest.model.client.Client;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentRequestBody {

    @JsonProperty("payment")
    @Valid
    private PaymentMethodDTO paymentDTO;

    @JsonProperty("buyer")
    @Valid
    private Buyer buyer;

    @JsonProperty("client")
    private Client client;


    public PaymentMethodDTO getPaymentDTO() {
        return paymentDTO;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Client getClient() {
        return client;
    }
}
