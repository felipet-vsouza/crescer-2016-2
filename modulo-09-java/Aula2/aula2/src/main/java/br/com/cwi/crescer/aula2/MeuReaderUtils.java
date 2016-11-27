package br.com.cwi.crescer.aula2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MeuReaderUtils {

    public static void type(String path) {
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            System.err.println("O arquivo indicado é inválido.");
            return;
        }
        if (!getExtension(file).equals("txt")) {
            System.err.println("O arquivo indicado é incompatível.");
            return;
        }
        try (
                BufferedReader reader = new BufferedReader(new FileReader(file));) {
            String line = "";
            do {
                line = reader.readLine();
                if (line != null) {
                    System.out.println(line);
                }
            } while (line != null);
        } catch (IOException e) {
            System.err.println("Problema na leitura do arquivo.");
        }
    }

    private static String getExtension(File file) {
        String extension = "";
        int pos = file.getName().lastIndexOf('.');
        if (pos > 0) {
            extension = file.getName().substring(pos + 1);
        }
        return extension;
    }
}
