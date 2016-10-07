import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExercitoDeElfos implements Exercito, EstrategiaDeAtaque {
    private ArrayList<Elfo> contingente;
    
    public ExercitoDeElfos() {
        this.contingente = new ArrayList<>();
    }
    
    public void alistar(Elfo elfo) throws NaoPodeAlistarException {
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            this.contingente.add(elfo);
        } else {
            throw new NaoPodeAlistarException();
        }
    }
    
    public ArrayList<Elfo> buscar(Status status) {
        ArrayList<Elfo> listaDeStatus = new ArrayList<>();
        for(Personagem elfo : this.contingente) {
            if(elfo.getStatus().equals(status)) {
                listaDeStatus.add((Elfo) elfo);
            }
        }
        return listaDeStatus;
    }

    public Elfo buscar(String nome) {
        for(Elfo elfo : contingente) {
            if(nome.equals(elfo.getNome())){
                return elfo;
            }
        }
        return null;
    }
    
    public Elfo[] getContingente() {
        return this.contingente.toArray(new Elfo[this.contingente.size()]);
    }
    
    public List<Elfo> getOrdemDeAtaque() {
        ArrayList<Elfo> ordemDeAtaque = new ArrayList<>();
        ordemDeAtaque.addAll(this.contingente
            .stream()
            .filter(e -> e instanceof ElfoVerde && e.getStatus().equals(Status.VIVO))
            .collect(Collectors.toList()));
        ordemDeAtaque.addAll(this.contingente
            .stream()
            .filter(e -> e instanceof ElfoNoturno && e.getStatus().equals(Status.VIVO))
            .collect(Collectors.toList()));
        return ordemDeAtaque;
    }
}