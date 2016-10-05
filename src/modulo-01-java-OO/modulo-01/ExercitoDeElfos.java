public class ExercitoDeElfos extends Exercito {
    public ExercitoDeElfos() {
        super();
    }
    
    public void alistarElfo(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            this.contingente.add(elfo);
        }
    }
}