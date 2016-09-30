import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item> lista;
    
    {
        this.lista = new ArrayList<>();
    }
    
    public void adicionarItem(Item item) {
        this.lista.add(item);
    }
    
    public void removerItem(Item item) {
        this.lista.remove(this.lista.indexOf(item));
    }
    
    public ArrayList<Item> getLista() {
        return this.lista;
    }
}