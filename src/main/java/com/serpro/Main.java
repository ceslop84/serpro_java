package com.serpro;

class Main{

    public static void main(String[] args){

        Pessoa pessoa = new Pessoa("masculino");
        pessoa.lacoFor();
        pessoa.clausulaIf();
        pessoa.clausulaSwitch();
        pessoa.tratamentoExcecao();
        pessoa.conexaoBancoDados();
        pessoa.documentacao(1, 2.0, "ahhhhhh");
        pessoa.manipulacaoString("veja isso aqui");
        pessoa.escreverArquivo("teste.txt");
        pessoa.lerArquivo("teste.txt");
        Funcionario funcionario = new Funcionario("masculino", 37, "Engenheiro");
        funcionario.lacoFor();
    }

}