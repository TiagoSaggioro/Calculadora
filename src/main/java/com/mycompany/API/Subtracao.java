package com.mycompany.API;

public class Subtracao implements Operacao {

    @Override
    public double calcular(Double a, Double b) {
        return a - b;
    }
}