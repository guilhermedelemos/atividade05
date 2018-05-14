/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.guilhermedelemos.atividade05.exercicio5;

/**
 *
 * @author guilherme
 */
public class Somatoria {

    MathOps mathOps;

    public Somatoria(MathOps mathOps) {
        this.mathOps = mathOps;
    }

    public int somaDeFatoriais(int numeros[], Primo p) {
        int soma = 0;
        for (int i = 0; i < numeros.length; i++) {
            int numero = numeros[i];
            if (!p.ehPrimo(numero)) {
                soma += numero;
            }
        }
        return 0;
    }
}
