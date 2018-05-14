/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.guilhermedelemos.atividade05;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author guilherme
 */
public class SomatoriaTest {
    
    public SomatoriaTest() {
    }

    @Test
    public void somaDeFatoriais1Test() {
        int[] valoresTeste = {5, 10};
        
        Primo pMock = mock(Primo.class);
        when(pMock.ehPrimo(5)).thenReturn(Boolean.TRUE);
        when(pMock.ehPrimo(10)).thenReturn(Boolean.FALSE);
        
        MathOps moMock = mock(MathOps.class);
        when(moMock.fatorial(10)).thenReturn(3628800);
        
        Somatoria s = new Somatoria(moMock);
        assertEquals(3628800, s.somaDeFatoriais(valoresTeste, pMock));
    }
}
