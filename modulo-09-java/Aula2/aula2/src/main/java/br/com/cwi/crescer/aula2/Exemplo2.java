package br.com.cwi.crescer.aula2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Exemplo2 {

    public static void main(String[] args) {
        try {
            Reader reader = new FileReader("aula2.txt");
            BufferedReader bufferReader = new BufferedReader(reader);
            String line = "";
            while(line != null) {
                line = bufferReader.readLine();
                if(line != null)
                    System.out.println(line);
            }
            bufferReader.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
