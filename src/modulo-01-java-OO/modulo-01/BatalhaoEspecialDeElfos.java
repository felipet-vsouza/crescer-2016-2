import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BatalhaoEspecialDeElfos implements Exercito, EstrategiaDeAtaque {
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

    public List<Elfo> getOrdemDeAtaque(List<Elfo> elfos, List<Dwarf> dwarves) throws ContingenteDesproporcionalException {
        ArrayList<Elfo> ordemDeAtaque = new ArrayList<>();
        List<Elfo> elfosVivos = new ArrayList<>();
        int verdes = 0, noturnos = 0;
        Class primeiroElfo = null;
        for(Elfo e : elfos) {
            if(primeiroElfo == null && e.getStatus().equals(Status.VIVO)) {
                primeiroElfo = e.getClass();
            }
            if(e instanceof ElfoVerde) {
                verdes++;
            } else {
                noturnos++;
            }
            elfosVivos.add(e);
        }
        if(verdes != noturnos) {
            throw new ContingenteDesproporcionalException();
        }
        int ultimoDiferente = 0;
        for(int i = 0; i < elfosVivos.size(); i++) {
            Elfo elfo = elfosVivos.get(i);
            if(elfo.getClass().isAssignableFrom(primeiroElfo)) {
                ordemDeAtaque.add(elfo);
                for(int j = ultimoDiferente; j < elfosVivos.size(); j++) {
                    Elfo elfo2 = elfosVivos.get(j);
                    if(!(elfo2.getClass().isAssignableFrom(primeiroElfo))) {
                        ordemDeAtaque.add(elfo2);
                        ultimoDiferente = j;
                        break;
                    }
                }
            }
        }
        return ordemDeAtaque;
    }
}
