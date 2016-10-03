public class Personagem {
    protected String nome;
    protected int exp;
    protected Status status;
    protected Inventario inventario;

    public Personagem(String nome) {
        this.nome = nome;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
    }
    
    public Inventario getInventario() {
        return this.inventario;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public int getExp() {
        return this.exp;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
}