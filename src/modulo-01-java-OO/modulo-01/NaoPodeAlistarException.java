public class NaoPodeAlistarException extends Exception {
    private Elfo elfo;
    
    public NaoPodeAlistarException () {
        super("Não foi possível alistar o elfo.");
    }
    
    public NaoPodeAlistarException(Elfo elfo) {
        super("Não foi possível alistar o elfo " + elfo.getNome() + ".");
    }
}