import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExercitoDeElfos implements Exercito {
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
}