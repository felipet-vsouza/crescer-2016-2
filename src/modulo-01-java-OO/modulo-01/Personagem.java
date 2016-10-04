public abstract class Personagem {
    protected String nome;
    protected int exp;
    protected double hp;
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
    
    public double getHp(){
        return this.hp;
    }
    
    public void adicionarItem(Item item) {
        this.inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item) {
        this.inventario.removerItem(item);
    }
}