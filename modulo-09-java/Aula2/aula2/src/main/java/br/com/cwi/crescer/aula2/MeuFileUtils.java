package br.com.cwi.crescer.aula2;

import java.io.File;
import java.io.IOException;

public class MeuFileUtils {

    public static void main(String[] args) {
//        execCommand("mk C:/TEMPERA/TEMPERA/TEMPERA/TEMPERA/ué.txt");
//        execCommand("mk C:/TEMPERA/ué.txt");
//        execCommand("rm C:/TEMPERA/ué.txt");
//        execCommand("rm C:/TEMPERA");
        execCommand("ls C:/tmp");
        execCommand("ls C:/TEMPERA/TEMPERA/TEMPERA/TEMPERA");
        execCommand("ls C:/TEMPERA/TEMPERA/TEMPERA/TEMPERA/ué.txt");
        execCommand("mv C:/tmp/ola.txt C:/TEMP");
    }

    public static void execCommand(String command) {
        String start = command.toLowerCase().substring(0, 2);
        String[] args = command.split(" ");
        switch (start) {
            case "mk":
                if (args.length == 2) {
                    create(new File(args[1]));
                }
                break;
            case "rm":
                if (args.length == 2) {
                    remove(new File(args[1]));
                }
                break;
            case "ls":
                if (args.length == 2) {
                    list(new File(args[1]));
                }
                break;
            case "mv":
                if (args.length == 3) {
                    System.out.println("Alright");
                }
                break;
            default:
                System.err.println("Comando inválido.");
                break;
        }
    }

    public static void create(File file) {
        boolean isFile = file.getName().lastIndexOf('.') > 0;
        if (file.exists()) {
            System.out.println("O arquivo/diretório indicado já existe.");
        } else if (isFile) {
            File parent = new File(file.getParent());
            if (!parent.exists()) {
                create(parent);
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Problema na criação do arquivo.");
            }
        } else {
            try {
                file.mkdirs();
            } catch (SecurityException e) {
                System.err.println("Problema na criação do diretório.");
            }
        }
    }

    public static void remove(File file) {
        file.delete();
    }
    
    public static void list(File file) {
        if(!file.exists()) {
            System.out.println("O arquivo/diretório indicado não existe.");
        } else if(file.isFile()) {
            System.out.println(file.getAbsolutePath());
        } else {
            System.out.format("Conteúdos de %s:\n", file.getAbsolutePath());
            for(File sub : file.listFiles()) {
                System.out.println(sub.getName());
            }
        }
    }
}
