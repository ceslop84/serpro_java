package com.serpro;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PessoaTest {

    @Test
    public void testFuncao(){
        int a=6, b=3;
        Pessoa pessoa = new Pessoa("masculino");
        int esperado = a+b;
        int observado = pessoa.funcaoParaSerTestada(a, b);
        assertEquals(esperado, observado);
    }
}
