public class Elfo {
    private String nome;
    private Item arco;
    private Item flecha;
    private int exp;
    private Status status;

    public Elfo(String nome) {
        // Chamando construtor de baixo
        this(nome, 42);
    }
    
    public Elfo(String nome, int quantidadeFlechas){
        this.nome = nome;
        this.arco = new Item("Arco", 1);
        this.flecha = new Item("Flechas", quantidadeFlechas >= 0 ? quantidadeFlechas : 42);
        this.status = Status.VIVO;
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }
    
    public Item getArco() {
        return this.arco;
    }
    
    public Item getFlecha() {
        return this.flecha;
    }
    
    public int getExp() {
        return this.exp;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        if(flecha.getQuantidade() > 0){
            dwarf.recebeDano(10);
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            exp++;
        }
    }
    
    public String toString() {
        boolean flechaNoSingular = this.flecha.getQuantidade() == 1;
        boolean experienciaNoSingular = this.exp == 1;
        return String.format("%s possui %d %s e %d %s de experiência.", this.nome,
            this.flecha.getQuantidade(),
            flechaNoSingular ? "flecha" : "flechas",
            this.exp,
            experienciaNoSingular ? "nível" : "níveis");
    }

    /*public void atirarFlechaRefactory(){
        flecha.setQuantidade(flecha.getQuantidade()-1);
        experiencia++;
    }*/
}


