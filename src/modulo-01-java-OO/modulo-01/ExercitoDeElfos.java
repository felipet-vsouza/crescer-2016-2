import java.util.ArrayList;

public class ExercitoDeElfos implements Exercito {
    private ArrayList<Elfo> contingente;
    
    public ExercitoDeElfos() {
        this.contingente = new ArrayList<>();
    }
    
    public void alistar(Elfo elfo){
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