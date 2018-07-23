package br.com.matheus.moiptest.controller;

import br.com.matheus.moiptest.dto.PaymentRequestBody;
import br.com.matheus.moiptest.service.PaymentService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment/")
public class PaymentRestController {


    private PaymentService service;

    @Autowired
    public PaymentRestController(PaymentService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity receive(@RequestBody @Valid PaymentRequestBody requestBody) {

        return ResponseEntity.ok(service.process(requestBody));
    }

}
