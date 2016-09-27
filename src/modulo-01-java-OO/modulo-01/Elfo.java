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

    public void atirarFlecha() {
        flecha.setQuantidade(flecha.getQuantidade() - 1);
        exp++;
    }

    /*public void atirarFlechaRefactory(){
        flecha.setQuantidade(flecha.getQuantidade()-1);
        experiencia++;
    }*/
}


