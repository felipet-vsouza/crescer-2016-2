package br.com.cwi.crescer.aula1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class StringRun {

    public static void main(String[] args) throws ParseException {
        System.out.println(listaDeEstados());
        Parcelator p = new Parcelator(1389.90, 0.10, 12, new SimpleDateFormat("dd/MM/yyyy").parse("30/12/2016"));
        System.out.println(p.getParcelas());
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
