/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.guilhermedelemos.atividade05;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author guilherme
 */
public class RelatorioDeFuncionariosTest {

    public RelatorioDeFuncionariosTest() {
    }
    
    @Test
    public void cenario1Test() {
        FuncionarioDAO fDaoMock = mock(FuncionarioDAO.class);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ReceitaFederal rfMock = mock(ReceitaFederal.class);
        
        // MOCK FuncionarioDAO
        this.fDaoMock = mock(FuncionarioDAO.class);
        this.funcionarios = new ArrayList<>();
        this.funcionarios.add(new Funcionario(1, "Tecnico 1", "111111111-11")); // N-BLOQUEADO
        this.funcionarios.add(new Funcionario(2, "Tecnico 2", "222222222-22")); // N-BLOQUEADO
        when(this.fDaoMock.getFuncionariosBy("tecnico")).thenReturn(this.funcionarios);

        // MOCK ReceitaFederal
        this.rfMock = mock(ReceitaFederal.class);
        when(this.rfMock.isCPFBloqueado("111111111-11")).thenReturn(Boolean.FALSE);
        when(this.rfMock.isCPFBloqueado("222222222-22")).thenReturn(Boolean.FALSE);
        
        // TESTE
        RelatorioDeFuncionarios rf = new RelatorioDeFuncionarios(this.fDaoMock);
        rf.setRf(this.rfMock);
        assertEquals(0, rf.getFuncComCPFBloqueado("tecnico"));
    }
}
