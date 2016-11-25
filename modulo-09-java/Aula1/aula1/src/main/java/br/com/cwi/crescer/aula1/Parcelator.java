package br.com.cwi.crescer.aula1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Parcelator {

    public Parcelator(double valor, double taxa, int quantidadeParcelas, Date primeira) {
        this.valor = valor;
        this.taxa = taxa;
        this.quantidadeParcelas = quantidadeParcelas;
        this.primeira = primeira;
    }

    private double valor;
    private double taxa;
    private int quantidadeParcelas;
    private Date primeira;

    public String getParcelas() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.primeira);
        double total = this.valor * (this.taxa + 1);
        double parcela = total / this.quantidadeParcelas;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.quantidadeParcelas; i++) {
            sb.append(format.format(cal.getTime()))
                    .append(" - R$ ")
                    .append(parcela)
                    .append("\n");
            cal.add(Calendar.MONTH, 1);
        }
        return sb.toString();
    }
}
