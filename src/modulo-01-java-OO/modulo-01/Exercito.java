import java.util.ArrayList;

public interface Exercito {
    public void alistar(Elfo elfo)throws NaoPodeAlistarException;

    public Elfo[] getContingente();

    public ArrayList<Elfo> buscar(Status status);

    public Elfo buscar(String nome);
}