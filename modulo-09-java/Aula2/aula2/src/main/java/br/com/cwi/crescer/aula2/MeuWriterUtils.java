package br.com.cwi.crescer.aula2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MeuWriterUtils {

    public static void append(String path, List<String> content) {
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            System.err.println("O arquivo indicado é inválido.");
            return;
        }
        if (!MeuFileUtils.getExtension(file).equals("txt")) {
            System.err.println("O arquivo indicado é incompatível.");
            return;
        }
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));) {
            for (String line : content) {
                writer.append(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Problema na leitura do arquivo.");
        }
    }
}
