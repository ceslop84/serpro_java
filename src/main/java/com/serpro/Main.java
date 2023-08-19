package com.serpro;

class Main{

    public static void main(String[] args){

        Pessoa pessoa = new Pessoa("masculino");
        pessoa.metodoPublico();
        pessoa.lacoFor();
        pessoa.clausulaIf();
        pessoa.clausulaSwitch();
        pessoa.tratamentoExcecao();
        pessoa.documentacao(1, 2.0, "ahhhhhh");
        pessoa.manipulacaoString("veja isso aqui");
        pessoa.conexaoBancoDados();
        pessoa.escreverArquivo("teste.txt");
        pessoa.lerArquivo("teste.txt");
        Funcionario funcionario = new Funcionario("masculino", 37, "Engenheiro");
        funcionario.lacoFor();
    }

}