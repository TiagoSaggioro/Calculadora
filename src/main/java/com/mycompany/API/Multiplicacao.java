package com.mycompany.API;

public class Multiplicacao implements Operacao {

    @Override
    public double calcular(Double a, Double b) {
        return a * b;
    }
}
