package com.serpro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Pessoa{
    private String sexo;
    private int idade;

    public Pessoa(String sexo){
        this.setSexo(sexo);
        this.setIdade(-1);
    }

    public Pessoa(String sexo, int idade){
        this(sexo);
        this.setIdade(idade);
    }

    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    public String getSexo(){
        return this.sexo;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public int getIdade(){
        return this.idade;
    }
    
    protected void metodoProtegido(){
        System.out.println("Idade " + this.getIdade());
    }

    private void metodoPrivate(){
        System.out.println("Sexo " + this.getSexo());
    }

    public void metodoPublico(){
        this.metodoProtegido();
        this.metodoPrivate();
    }

    public void lacoFor(){
        List<Integer> listaArray = new ArrayList<Integer>();
        listaArray.add(1);
        listaArray.add(2);
        listaArray.add(3);
        listaArray.remove(0);
        int[] lista1 = {0,1,2,3,4,5};
        for (int i : lista1){
            System.out.println(i);
        }

        int[] lista2 = new int[10];
        for (int i=0; i<lista2.length;i++){
            lista2[i] = i;
        }

        HashMap<String, String> dicionario = new HashMap<String, String>();
        dicionario.put("nome", "Cesar Rafael Lopes");
        dicionario.put("idade", "37");
        dicionario.put("sexo", "masculino");
        for (Map.Entry<String, String> registro : dicionario.entrySet()){
            String key = registro.getKey();
            String value = registro.getValue();
            System.out.println(key + " " + value);
        }
    }

    public void clausulaIf(){
        if (this.getIdade()>65){
            System.out.println("Maior de 65 anos.");
        } else if (this.getIdade()<18){
            System.out.println("Menor de 18 anos.");
        } else {
            System.out.println("Adulto.");
        }
    }

    public void clausulaSwitch(){
        switch (this.getSexo()){
            case "masculino":
                System.out.println("É homem.");
                break;
            case "feminino":
                System.out.println("É mulher.");
                break;
            default:
                System.out.println("Não previsto!");
        }
    }

    public void tratamentoExcecao(){
        try {
            System.err.println("Tentando resolver algo...");
            throw new UnsupportedOperationException();
        } catch (Exception e) {
            System.out.println("Peguei a exceção!" + e.getMessage());
        } finally{
            System.out.println("Isso aqui sempre vai ser tratado!");
        }
    }

    /**
     * Este é um exemplo de documentação.
     * @param param1 número inteiro.
     * @param param2 número decimal.
     * @param param3 valor em texto.
     * @return texto processado.
     */
    public String documentacao(int param1, double param2, String param3){
        return param1 + " e " + param2 + " e " + param3;        
    }

    public void conexaoBancoDados(){
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db")){
            Statement statement = null;
            PreparedStatement preparedStatement = null;
            ResultSet result = null;
            statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS movie");
            statement.execute("CREATE TABLE movie(title, year, score)");
            connection.close();
        } catch (SQLException e){
            System.out.println("Erro ao executar query:" + e.getMessage());
        }
        
    }
}