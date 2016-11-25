package br.com.cwi.crescer.aula2;

import br.com.cwi.crescer.aula1.MeuCalendarioUtil;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Exemplo1 {

    public static void main(String[] args) {
        final File file = new File("aula2.txt");
        try {
            file.createNewFile();
            if(file.exists())
                System.out.println(file.getAbsolutePath());
            String path = "C:\\Users\\felipe.souza\\github\\jogo-da-forca";
            Arrays.asList(new File(path).listFiles(f -> f.getName().contains(".md")))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Final.");
    }

}
