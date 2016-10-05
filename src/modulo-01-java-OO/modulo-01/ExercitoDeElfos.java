import java.util.ArrayList;

public class ExercitoDeElfos {
    private ArrayList<Elfo> contingente;
    
    public ExercitoDeElfos() {
        this.contingente = new ArrayList<>();
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

    public Elfo buscarPeloNome(String nome) {
        for(Elfo elfo : contingente) {
            if(nome.equals(elfo.getNome())){
                return elfo;
            }
        }
        return null;
    }
    
    public ArrayList<Elfo> getContingente() {
        return this.contingente;
    }
}