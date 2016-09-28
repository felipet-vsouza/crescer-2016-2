public class Elfo {
    private String nome;
    private Item arco;
    private Item flecha;
    private int exp;

    public Elfo(String n) {
        nome = n;
        arco = new Item("Arco", 1);
        flecha = new Item("Flechas", 42);
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
    
    public void atirarFlecha(Dwarf dwarf) {
        if(flecha.getQuantidade() > 0){
            dwarf.recebeDano(10);
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            exp++;
        }
    }
    
    public String toString() {
        return this.nome + " possui " + this.flecha.getQuantidade() + " flechas e " +
               this.exp + " níveis de experiência.";
    }

    /*public void atirarFlechaRefactory(){
        flecha.setQuantidade(flecha.getQuantidade()-1);
        experiencia++;
    }*/
}


