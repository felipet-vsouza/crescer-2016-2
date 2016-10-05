import java.util.ArrayList;

public abstract class Exercito {
    protected ArrayList<Personagem> contingente;

    public Exercito() {
        this.contingente = new ArrayList<>();
    }

    public Personagem buscarPeloNome(String nome) {
        for(Personagem soldado : contingente) {
            if(soldado.getNome().equals(nome)){
                return soldado;
            }
        }
        return null;
    }
    
    public ArrayList<Personagem> getContingente() {
        return this.contingente;
    }
}