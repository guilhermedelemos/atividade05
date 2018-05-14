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
        fDaoMock = mock(FuncionarioDAO.class);
        funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario(1, "Tecnico 1", "111111111-11")); // N-BLOQUEADO
        funcionarios.add(new Funcionario(2, "Tecnico 2", "222222222-22")); // N-BLOQUEADO
        when(fDaoMock.getFuncionariosBy("tecnico")).thenReturn(funcionarios);

        // MOCK ReceitaFederal
        rfMock = mock(ReceitaFederal.class);
        when(rfMock.isCPFBloqueado("111111111-11")).thenReturn(Boolean.FALSE);
        when(rfMock.isCPFBloqueado("222222222-22")).thenReturn(Boolean.FALSE);
        
        // TESTE
        RelatorioDeFuncionarios rf = new RelatorioDeFuncionarios(fDaoMock);
        rf.setRf(rfMock);
        assertEquals(0, rf.getFuncComCPFBloqueado("tecnico"));
    }
}
