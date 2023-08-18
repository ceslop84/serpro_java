package com.serpro;

import com.serpro.Pessoa;

class Main{

    public static void main(String[] args){

        Pessoa pessoa = new Pessoa("masculino");
        pessoa.lacoFor();
        pessoa.clausulaIf();
        pessoa.clausulaSwitch();
        pessoa.tratamentoExcecao();
        pessoa.documentacao(1, 2.0, "ahhhhhh");
        pessoa.conexaoBancoDados();
    }

}