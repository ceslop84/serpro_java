package com.serpro;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
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

            preparedStatement = connection.prepareStatement("INSERT INTO movie VALUES (?, ?, ?)");
            preparedStatement.setString(1,"Monty Python and the Holy Grail");
            preparedStatement.setInt(2, 1975);
            preparedStatement.setDouble(3, 8.2);
            preparedStatement.executeUpdate();

            preparedStatement.setString(1,"And Now for Something Completely Different");
            preparedStatement.setInt(2, 1971);
            preparedStatement.setDouble(3, 7.5);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("DELETE FROM movie WHERE year=?");
            preparedStatement.setInt(1, 1971);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("UPDATE movie SET year = ? WHERE year = ?");
            preparedStatement.setInt(1, 1984);
            preparedStatement.setInt(2, 1971);
            preparedStatement.executeUpdate();

            result = statement.executeQuery("SELECT * FROM movie");
            while(result.next()){
                System.out.printf("Title: %s, Year: %s, Score: %s", result.getString("title"), result.getString("year"), result.getString("score"));
            }

            connection.close();
        } catch (SQLException e){
            System.out.println("Erro ao executar query:" + e.getMessage());
        }
        
    }

    public void manipulacaoString(String texto){
        System.out.println("Primeiros 5 caracteres: " + texto.substring(0, 5));
        System.out.println("Esta string tem " + texto.length() + " caracteres");
        System.out.println("Em caixa baixa: " + texto.toLowerCase());
        System.out.println("Em caixa ALTA: " + texto.toUpperCase());
        System.out.println("Substituindo: " + texto.replaceAll("a", "b"));
        System.out.println("Split: " + Arrays.toString(texto.split(" ")));
        String [] array = texto.split(" ");
        String [] arrayCopy = Arrays.copyOf(array, array.length);
        String max = Collections.max(Arrays.asList(arrayCopy));
        String min = Collections.min(Arrays.asList(arrayCopy));
        Arrays.sort(arrayCopy);
        System.out.println("To string: " + Arrays.toString(array));
        System.out.println("To string: " + Arrays.toString(arrayCopy));
        System.out.println("Valor máximo: " + max);
        System.out.println("Valor mínimo: " + min);
    }

    public int funcaoParaSerTestada(int valor1, int valor2){
        return valor1 + valor2;
    }

    public void escreverArquivo(String nomeArquivo){
       
        int[] conteudo_lista = new int[]{0,1,2,3,4,5,6,7,8,9,10};
        HashMap<String, String> conteudo_dicionario = new HashMap<String, String>();
        conteudo_dicionario.put("nome", "teste");
        conteudo_dicionario.put("idade", "37");

        try{
            // Para acrescentar ao arquivo usar "new FileWriter(nomeArquivo, true)".
            FileWriter arquivo = new FileWriter(nomeArquivo);
            for (int valor : conteudo_lista){
                arquivo.write(valor + "\n");
            }

            for (Map.Entry<String, String> registro : conteudo_dicionario.entrySet()){
                arquivo.write(registro.getKey() + ": " + registro.getValue() + "\n");
            }

            arquivo.close();
        } catch (IOException e){
            System.out.println("Erro ao criar arquivo: " + e.getMessage());
        }
    }

    public void lerArquivo(String nomeArquivo){
        try{
            FileReader arquivo = new FileReader(nomeArquivo);
            Scanner conteudo = new Scanner(arquivo);
            while (conteudo.hasNextLine()){
                String data = conteudo.nextLine();
                System.out.println(data);
            }
            conteudo.close();
            arquivo.close();
        } catch (IOException e){
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    public void entradaUsuario(){
        Scanner input = new Scanner(System.in);
        System.out.println("Entrar com o dado de teste:");
        String texto = input.nextLine();
        System.out.println("O texto de entrada é: " + texto);
        input.close();
    }

    public void  manipulacaoData(String data){
        LocalDateTime agora = LocalDateTime.now();
        System.out.println("Parâmetros de hoje " + agora.getYear() + " " + agora.getMonthValue() + " " + agora.getDayOfMonth() + " " + agora.getHour() + " " + agora.getMinute() + " " + agora.getSecond());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Agora formatado: " + agora.format(formatter));
        System.out.println("Daqui uma semana: " + agora.plusWeeks(1).format(formatter));  
        System.out.println("Daqui 30 dias: " + agora.plusDays(30).format(formatter));  
        LocalDateTime fimAno = LocalDateTime.of(2023, 12, 31, 0, 0, 0);
        Duration duration = Duration.between(agora, fimAno);
        System.out.println("Dias para o final do ano: " + duration.toDays());
        String [] dataListaStr = data.split("/");
        int [] dataListaInt = new int[dataListaStr.length];
        for (int i=0; i<dataListaStr.length; i++){
            dataListaInt[i] = Integer.parseInt(dataListaStr[i]);

        }
        LocalDateTime dataInformada = LocalDateTime.of(dataListaInt[2], dataListaInt[1], dataListaInt[0], 0, 0, 0);
        System.out.println("Data informada: " + dataInformada.format(formatter));  
    }
}