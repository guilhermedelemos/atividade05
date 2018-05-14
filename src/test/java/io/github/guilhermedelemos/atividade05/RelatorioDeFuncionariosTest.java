/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.guilhermedelemos.atividade05;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import static org.mockito.Mockito.*;

/**
 *
 * @author guilherme
 */
public class RelatorioDeFuncionariosTest {

    private static FuncionarioDAO fDaoMock;
    private static ReceitaFederal rfMock;
    private static RelatorioDeFuncionarios rf;

    public RelatorioDeFuncionariosTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        fDaoMock = mock(FuncionarioDAO.class);
        rfMock = mock(ReceitaFederal.class);
        rf = new RelatorioDeFuncionarios(fDaoMock);
    }

    @Test
    public void cenario1Test() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario(1, "Tecnico 1", "111111111-11")); // N-BLOQUEADO
        funcionarios.add(new Funcionario(2, "Tecnico 2", "222222222-22")); // N-BLOQUEADO
        when(fDaoMock.getFuncionariosBy("tecnico")).thenReturn(funcionarios);

        // MOCK ReceitaFederal
        rfMock = mock(ReceitaFederal.class);
        when(rfMock.isCPFBloqueado("111111111-11")).thenReturn(Boolean.FALSE);
        when(rfMock.isCPFBloqueado("222222222-22")).thenReturn(Boolean.FALSE);

        // TESTE
        rf.setRf(rfMock);
        assertEquals(0, rf.getFuncComCPFBloqueado("tecnico"));
    }

    @Test
    public void cenario2Test() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario(3, "Analista 1", "333333333-33")); //  BLOQUEADO
        when(fDaoMock.getFuncionariosBy("analista")).thenReturn(funcionarios);

        // MOCK ReceitaFederal
        rfMock = mock(ReceitaFederal.class);
        when(rfMock.isCPFBloqueado("333333333-33")).thenReturn(Boolean.TRUE);

        // TESTE
        rf.setRf(rfMock);
        assertEquals(1, rf.getFuncComCPFBloqueado("analista"));
    }

    @Test
    public void cenario3Test() {
        // MOCK FuncionarioDAO
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario(4, "Gerente 1", "123456789-00")); // N-BLOQUEADO
        funcionarios.add(new Funcionario(5, "Gerente 2", "111222333-44")); //  BLOQUEADO
        funcionarios.add(new Funcionario(6, "Gerente 3", "654321987-23")); // N-BLOQUEADO
        funcionarios.add(new Funcionario(7, "Gerente 4", "098876654-99")); //  BLOQUEADO
        when(fDaoMock.getFuncionariosBy("gerente")).thenReturn(funcionarios);

        // MOCK ReceitaFederal
        when(rfMock.isCPFBloqueado("123456789-00")).thenReturn(Boolean.FALSE);
        when(rfMock.isCPFBloqueado("111222333-44")).thenReturn(Boolean.TRUE);
        when(rfMock.isCPFBloqueado("654321987-23")).thenReturn(Boolean.FALSE);
        when(rfMock.isCPFBloqueado("098876654-99")).thenReturn(Boolean.TRUE);

        // TESTE
        rf.setRf(rfMock);
        assertEquals(2, rf.getFuncComCPFBloqueado("gerente"));
    }

}
