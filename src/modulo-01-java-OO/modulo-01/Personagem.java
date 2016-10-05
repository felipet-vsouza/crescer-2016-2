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
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Personagem)){
            return false;
        }
        Personagem p = (Personagem) obj;
        return this.nome.equals(p.getNome()) && 
            this.exp == p.getExp() && 
            this.hp == p.getHp() && 
            this.status == p.getStatus();
    }
}