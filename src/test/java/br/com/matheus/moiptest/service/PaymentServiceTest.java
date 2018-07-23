package br.com.matheus.moiptest.service;

import br.com.matheus.moiptest.dto.PaymentMethodDTO;
import br.com.matheus.moiptest.dto.PaymentRequestBody;
import br.com.matheus.moiptest.infra.dao.BuyerDAO;
import br.com.matheus.moiptest.infra.dao.ClientDAO;
import br.com.matheus.moiptest.infra.dao.PaymentDAO;
import br.com.matheus.moiptest.infra.dao.PaymentMethodDAO;
import br.com.matheus.moiptest.model.buyer.Buyer;
import br.com.matheus.moiptest.model.client.Client;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

    @Mock
    private ClientDAO clientDAO;
    @Mock
    private PaymentMethodDAO paymentMethodDAO;
    @Mock
    private BuyerDAO buyerDAO;
    @Mock
    private PaymentDAO paymentDAO;

    @Mock
    private PaymentRequestBody requestBody;

    private PaymentService service;
    private Client client;
    private Buyer buyer;
    private PaymentMethodDTO paymentDTO;

    @Before
    public void setUp() {
        service = new PaymentService(paymentDAO, buyerDAO, clientDAO, paymentMethodDAO);
        client = new Client("Matheus");
        buyer = new Buyer("Outro Cara", "46960386888", "outro@cara.com.br");
        paymentDTO = new PaymentMethodDTO(BigDecimal.ONE, "Boleto", null);
    }


    @Test
    public void shouldShowAMessageThatNoFoundAClient() {

        when(requestBody.getClient()).thenReturn(client);

        when(clientDAO.findClientById(requestBody.getClient().getId())).thenReturn(Optional.empty());

        String response = service.process(requestBody);

        assertEquals("Cliente não existe na base, operação não concluida", response);
    }

    @Test
    public void shouldRunWithoutStop() {


        when(requestBody.getClient()).thenReturn(client);
        when(requestBody.getBuyer()).thenReturn(buyer);
        when(requestBody.getPaymentDTO()).thenReturn(paymentDTO);

        when(clientDAO.findClientById(client.getId())).thenReturn(Optional.of(client));
        when(buyerDAO.findBuyerByCpf(buyer.getCpf())).thenReturn(Optional.of(buyer));

        String response = service.process(requestBody);

        assertTrue(Integer.valueOf(response) instanceof Integer);

    }
}
