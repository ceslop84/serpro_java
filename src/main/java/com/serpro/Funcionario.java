package com.serpro;

public class Funcionario extends Pessoa{

    private String cargo;

    public Funcionario(String sexo, String cargo){
        super(sexo);
        this.setCargo(cargo);
    }

    public Funcionario(String sexo, int idade, String cargo){
        super(sexo, idade);
        this.setCargo(cargo);
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public String getCargo(){
        return this.cargo;
    }

}