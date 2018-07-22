package br.com.matheus.moiptest.service;

import br.com.matheus.moiptest.dto.PaymentRequestBody;
import br.com.matheus.moiptest.infra.dao.BuyerDAO;
import br.com.matheus.moiptest.infra.dao.ClientDAO;
import br.com.matheus.moiptest.infra.dao.PaymentDAO;
import br.com.matheus.moiptest.infra.dao.PaymentMethodDAO;
import br.com.matheus.moiptest.model.buyer.Buyer;
import br.com.matheus.moiptest.model.client.Client;
import br.com.matheus.moiptest.model.payment.Payment;
import br.com.matheus.moiptest.model.payment.method.PaymentMethod;
import br.com.matheus.moiptest.model.payment.processes.ResponseProcess;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {


    private PaymentDAO paymentDAO;
    private BuyerDAO buyerDAO;
    private ClientDAO clientDAO;
    private PaymentMethodDAO paymentMethodDAO;

    @Autowired
    public PaymentService(PaymentDAO paymentDAO, BuyerDAO buyerDAO, ClientDAO clientDAO, PaymentMethodDAO paymentMethodDAO) {
        this.paymentDAO = paymentDAO;
        this.buyerDAO = buyerDAO;
        this.clientDAO = clientDAO;
        this.paymentMethodDAO = paymentMethodDAO;
    }

    public String process(PaymentRequestBody requestBody) {


        Client client = requestBody.getClient();

        if (notExist(client)) return "Cliente não existe na base, operação não concluida";

        Buyer buyer = saveIfNecessary(requestBody.getBuyer());

        PaymentMethod paymentMethod = savePaymentMethodOf(requestBody);

        Payment payment = new Payment(paymentMethod, buyer, client);

        paymentDAO.save(payment);

        ResponseProcess process = paymentMethod.process();

        return process.getResponse();
    }

    private PaymentMethod savePaymentMethodOf(PaymentRequestBody requestBody) {
        PaymentMethod paymentMethod = requestBody.getPaymentDTO().toPaymentMethod();
        paymentMethodDAO.save(paymentMethod);
        return paymentMethod;
    }

    private boolean notExist(Client client) {
        Optional<Client> clientSearched = clientDAO.findClientById(client.getId());

        return !clientSearched.isPresent();
    }

    private Buyer saveIfNecessary(Buyer buyer) {

        Optional<Buyer> buyerSearched = buyerDAO.findBuyerByCpf(buyer.getCpf());

        if (!buyerSearched.isPresent()) {
            buyerDAO.save(buyer);
            return buyer;
        }

        return buyerSearched.get();
    }
}
