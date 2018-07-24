package br.com.matheus.moiptest.controller;

import br.com.matheus.moiptest.infra.dao.PaymentDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/payment/")
public class PaymentController {

    private final PaymentDAO paymentDAO;

    @Autowired
    public PaymentController(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @GetMapping
    public ModelAndView openPayments() {

        ModelAndView modelAndView = new ModelAndView("payments");
        modelAndView.addObject("payments", paymentDAO.findAll());

        return modelAndView;
    }
}
