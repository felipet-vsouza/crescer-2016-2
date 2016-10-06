import java.util.HashMap;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class BatalhaoEspecialDeElfos {
    HashMap<String, ArrayList<Elfo>> contingente;
    HashMap<Status, ArrayList<Elfo>> porStatus;

    public BatalhaoEspecialDeElfos() {
        this.contingente = new HashMap<>();
        this.porStatus = new HashMap<>();
    }

    public Elfo[] getContingente() {
        ArrayList<Elfo> retorno = new ArrayList<>();
        for(ArrayList<Elfo> array : this.contingente.values()) {
            retorno.addAll(array);
        }
        return retorno.toArray(new Elfo[retorno.size()]);
    }

    public void alistar(Elfo elfo) {
        if(elfo != null && (elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)) {
            String key = elfo.getNome();
            if(!this.contingente.containsKey(key)) {
                this.contingente.put(key, new ArrayList<>());
            }
            this.contingente.get(key).add(elfo);
        }
    }

    private void agruparPorStatus() {
        this.porStatus.put(Status.VIVO, new ArrayList<>());
        this.porStatus.put(Status.MORTO, new ArrayList<>());
        this.contingente.values().stream().forEach(a -> {
                this.porStatus.get(Status.VIVO).addAll(a.stream()
                    .filter(e -> e.getStatus().equals(Status.VIVO))
                    .collect(Collectors.toList()));
                this.porStatus.get(Status.MORTO).addAll(a.stream()
                    .filter(e -> e.getStatus().equals(Status.MORTO))
                    .collect(Collectors.toList()));
            });
    }

    public Elfo buscar(String nome) {
        ArrayList<Elfo> posicao = this.contingente.get(nome);
        if(posicao != null) {
            return posicao.get(0);
        }
        return null;
    }

    public ArrayList<Elfo> buscar(Status status) {
        this.agruparPorStatus();
        ArrayList<Elfo> listaStatus = new ArrayList<>();
        listaStatus.addAll(this.porStatus.get(status));
        return listaStatus;
    }
}
