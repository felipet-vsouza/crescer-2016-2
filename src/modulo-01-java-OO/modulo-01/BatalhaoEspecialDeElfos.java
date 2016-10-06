import java.util.HashMap;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class BatalhaoEspecialDeElfos {
    HashMap<String, Elfo> contingente;

    public BatalhaoEspecialDeElfos() {
        this.contingente = new HashMap<>();
    }

    public Elfo[] getContingente() {
        return this.contingente.values().toArray(new Elfo[this.contingente.size()]);
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
        lista.addAll(this.contingente.values().stream()
            .filter(s -> s.getStatus().equals(status))
            .collect(Collectors.toList()));
        return lista;
    }
}
