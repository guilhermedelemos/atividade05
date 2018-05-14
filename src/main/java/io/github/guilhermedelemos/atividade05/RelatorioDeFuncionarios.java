/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.guilhermedelemos.atividade05;

import java.util.ArrayList;

/**
 *
 * @author guilherme
 */
public class RelatorioDeFuncionarios {

    private FuncionarioDAO funcDao;
    private ReceitaFederal rf;

    public RelatorioDeFuncionarios(FuncionarioDAO funcDao) {
        this.funcDao = funcDao;
    }

    public void setRf(ReceitaFederal rf) {
        this.rf = rf;
    }

    public int getFuncComCPFBloqueado(String categoria) {
        int numeroDeFuncionarios = 0;
        ArrayList<Funcionario> funcCategoria = funcDao.getFuncionariosBy(categoria);
        for (Funcionario f : funcCategoria) {
            if (rf.isCPFBloqueado(f.getCpf())) {
                numeroDeFuncionarios++;
            }
        }
        return numeroDeFuncionarios;
    }

}
