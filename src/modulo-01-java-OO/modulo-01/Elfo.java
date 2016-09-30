public class Elfo {
    private String nome;
    private int exp;
    private Status status;
    private Inventario inventario;

    public Elfo(String nome) {
        // Chamando construtor de baixo
        this(nome, 42);
    }
    
    public Elfo(String nome, int quantidadeFlechas){
        this.nome = nome;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
        this.inventario.adicionarItem(new Item("Arco", 1));
        this.inventario.adicionarItem(new Item("Flechas", quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }
    
    public Item getArco() {
        return this.inventario.getLista().get(0);
    }
    
    public Item getFlecha() {
        return this.inventario.getLista().get(1);
    }
    
    public int getExp() {
        return this.exp;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        if(this.getFlecha().getQuantidade() > 0){
            dwarf.recebeDano(10);
            this.getFlecha().setQuantidade(this.getFlecha().getQuantidade() - 1);
            exp++;
        }
    }
    
    public String toString() {
        boolean flechaNoSingular = this.getFlecha().getQuantidade() == 1;
        boolean experienciaNoSingular = this.exp == 1;
        return String.format("%s possui %d %s e %d %s de experiência.", this.nome,
            this.getFlecha().getQuantidade(),
            flechaNoSingular ? "flecha" : "flechas",
            this.exp,
            experienciaNoSingular ? "nível" : "níveis");
    }

    /*public void atirarFlechaRefactory(){
        flecha.setQuantidade(flecha.getQuantidade()-1);
        experiencia++;
    }*/
}


