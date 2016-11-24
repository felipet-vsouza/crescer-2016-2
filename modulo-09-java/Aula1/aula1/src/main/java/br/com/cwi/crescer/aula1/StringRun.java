package br.com.cwi.crescer.aula1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StringRun {

    public static void main(String[] args) {
//        System.out.print("Digite uma frase: ");
//        String frase = new Scanner(System.in).nextLine();
//        System.out.println("Quantidade total de vogais: " + contarVogais(frase));
//        System.out.println("String invertida: " + inverter(frase));

//        System.out.println(listaDeEstados());
        Date atual = Calendar.getInstance().getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        System.out.println(format.format(atual));
        
        try {
            System.out.print("Digite sua data de nascimento: ");
            String nascimento = new Scanner(System.in).nextLine();
            Date nasc = new SimpleDateFormat("dd/MM/yyyy").parse(nascimento);
            System.out.println("Você nasceu em um(a) " + 
                    new SimpleDateFormat("EEEE").format(nasc));
        } catch (ParseException ex) {
            System.err.println("Erro de conversão da data.");
        }
        
        System.out.println(MeuStringUtil.isPalindromo("A sogra má e amargosa"));
        System.out.println(MeuStringUtil.isPalindromo("Poladoful"));
    }

    public static int contarVogais(String frase) {
        int total = 0;
        for (char c : frase.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                total++;
            }
        }
        return total;
    }

    public static String inverter(String frase) {
        String invertida = "";
        char[] array = frase.toCharArray();
        for (int x = array.length - 1; x >= 0; x--) {
            invertida += array[x];
        }
        return invertida;
    }

    public static String listaDeEstados() {
        StringBuilder buffer = new StringBuilder();
        List<Estados> lista = Arrays.asList(Estados.values());
        lista.sort((Estados p, Estados q) -> {
            return p.getNome().compareToIgnoreCase(q.getNome());
        });
        lista.forEach((Estados p) -> {
            buffer.append(p.getNome()).append(", ");
        });
        buffer.deleteCharAt(buffer.length() - 2);
        return buffer.toString();
    }
}

enum Estados {
    AC("Acre"), AL("Alagoas"), ES("EspíritoSanto"), AP("Amapá"),
    BA("Bahia"), CE("Ceará"), DF("DistritoFederal"), GO("Goiás"),
    MA("Maranhão"), SC("SantaCatarina"), MG("MinasGerais"),
    MT("MatoGrosso"), MS("MatoGrossodoSul"), PA("Pará"),
    RS("RioGrandedoSul"), PE("Pernambuco"), PI("Piauí"),
    AM("Amazonas"), PR("Paraná"), RJ("RiodeJaneiro"),
    RN("RioGrandedoNorte"), PB("Paraíba"), RO("Rondônia"),
    RR("Roraima"), SE("Sergipe"), SP("SãoPaulo"), TO("Tocantins");

    private String nome;

    private Estados(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
