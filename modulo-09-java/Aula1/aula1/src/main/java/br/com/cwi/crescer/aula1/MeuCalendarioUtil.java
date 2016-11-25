package br.com.cwi.crescer.aula1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MeuCalendarioUtil {

    public static void main(String[] args) {
        System.out.println("Recursos disponíveis:");
        System.out.println("Dia da semana de nascimento: diaDaSemana(String)");
        System.out.println("Diferença de data: diferencaParaHoje(Date)");
    }

    public static String diaDaSemana(String nascimento) {
        String dia = "";
        try {
            Date nasc = new SimpleDateFormat("dd/MM/yyyy").parse(nascimento);
            dia = new SimpleDateFormat("EEEE").format(nasc);
        } catch (ParseException ex) {
            System.err.println("Erro de conversão da data.");
        }
        return dia;
    }

    public static void diferencaParaHoje(Date ref) {
        Calendar now = Calendar.getInstance();
        Calendar then = Calendar.getInstance();
        then.setTime(ref);
        int anos = now.get(Calendar.YEAR) - then.get(Calendar.YEAR);
        int meses = now.get(Calendar.MONTH) - then.get(Calendar.MONTH);
        int dias = now.get(Calendar.DAY_OF_MONTH) - then.get(Calendar.DAY_OF_MONTH);
        if (dias < 0) {
            dias += 30;
            meses--;
        }
        if (meses < 0) {
            meses += 12;
            anos--;
        }
        System.out.format("Diferença de %d ano(s), %d mes(es) e %d dia(s)", anos, meses, dias);
    }
}
