/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.guilhermedelemos.atividade05;

import io.github.guilhermedelemos.atividade05.exercicio5.Somatoria;
import io.github.guilhermedelemos.atividade05.exercicio5.MathOps;
import io.github.guilhermedelemos.atividade05.exercicio5.Primo;
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
        
        verify(pMock, times(2)).ehPrimo(anyInt());
        verify(moMock).fatorial(10);
    }
    
    @Test
    public void somaDeFatoriais2Test() {
        int[] valoresTeste = {3, 4, 4, 5};
        
        Primo pMock = mock(Primo.class);
        when(pMock.ehPrimo(3)).thenReturn(Boolean.TRUE);
        when(pMock.ehPrimo(4)).thenReturn(Boolean.FALSE);
        when(pMock.ehPrimo(5)).thenReturn(Boolean.TRUE);
        
        MathOps moMock = mock(MathOps.class);
        when(moMock.fatorial(4)).thenReturn(24);
        
        Somatoria s = new Somatoria(moMock);
        assertEquals(48, s.somaDeFatoriais(valoresTeste, pMock));
        
        verify(pMock, times(2)).ehPrimo(anyInt());
        verify(moMock).fatorial(4);
    }
    
}
