package com.serpro;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class FuncionarioTest {

    @Test
    public void testFuncaoParaSerTestada(){
        int a = 5;
        int b= 5;
        int esperado = a + b;
        Funcionario funcionario = new Funcionario("masculino", "engenheiro");
        int observado = funcionario.funcaoParaSerTestada(a, b);
        assertEquals(esperado, observado);
    }
    
}
