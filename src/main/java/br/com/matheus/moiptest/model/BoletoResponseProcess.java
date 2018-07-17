package br.com.matheus.moiptest.model;

import java.util.Random;

public class BoletoResponseProcess implements ResponseProcess {

    @Override
    public String getResponse() {
        return String.valueOf(new Random().nextInt(Integer.MAX_VALUE));
    }
}
