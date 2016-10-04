public class Elfo extends Personagem {
    
    {
        this.hp = 100;
    }
    
    public Elfo(String nome) {
        // Chamando construtor de baixo
        this(nome, 42);
    }
    
    public Elfo(String nome, int quantidadeFlechas) {
        super(nome);
        this.inicializarInventario(quantidadeFlechas);
    }
    
    public Item getArco() {
        return this.inventario.getLista().get(0);
    }
    
    public Item getFlecha() {
        return this.inventario.getLista().get(1);
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        this.atirarFlecha(dwarf, 1);
    }
    
    protected void atirarFlecha(Dwarf dwarf, int fatorExp) {
        if(this.getFlecha().getQuantidade() > 0){
            dwarf.recebeDano(10);
            this.getFlecha().setQuantidade(this.getFlecha().getQuantidade() - 1);
            exp += fatorExp;
        }
    }
    
    protected void inicializarInventario(int quantidadeFlechas) {
        this.inventario.adicionarItem(new Item("Arco", 1));
        this.inventario.adicionarItem(new Item("Flechas", quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
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


