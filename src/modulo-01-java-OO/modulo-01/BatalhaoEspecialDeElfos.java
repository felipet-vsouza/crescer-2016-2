import java.util.HashMap;
import java.util.ArrayList;

public class BatalhaoEspecialDeElfos {
    HashMap<String, Elfo> contingente;

    public BatalhaoEspecialDeElfos() {
        this.contingente = new HashMap<>();
    }

    public Elfo[] getContingente() {
        return this.contingente.values().toArray(new Elfo[0]);
    }

    public void alistar(Elfo elfo) {
        if(elfo != null && (elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)) {
            this.contingente.putIfAbsent(elfo.getNome(), elfo);
        }
    }

    public Elfo buscar(String nome) {
        return this.contingente.getOrDefault(nome, null);
    }

    public ArrayList<Elfo> buscar(Status status) {
        ArrayList<Elfo> lista = new ArrayList<>();
        this.contingente.values().stream().forEach(s -> {
                if(((Elfo) s).getStatus().equals(status)){
                    lista.add(s);
                }
            });
        return lista;
    }
}
