import java.util.ArrayList;

public class ExercitoDeElfos extends Exercito {
    public ExercitoDeElfos() {
        super();
    }
    
    public void alistarElfo(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            this.contingente.add(elfo);
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
}