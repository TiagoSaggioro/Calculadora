package com.mycompany.API;

public class Divisao implements Operacao {

    @Override
    public double calcular(Double a, Double b) {
        if (b == 0) {
            return 0;
        } else {
            return a / b;
        }
    }
}
