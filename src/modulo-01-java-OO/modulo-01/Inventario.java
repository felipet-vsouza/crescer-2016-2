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
    
    public String getDescricoesItens() {
        String retorno = "";
        for(int i = 0; i < this.lista.size(); i++) {
            String descricao = this.lista.get(i).getDescricao();
            retorno += descricao + (i == this.lista.size() - 1 ? "" : ",");
        }
        return retorno;
    }
    
    public ArrayList<Item> getLista() {
        return this.lista;
    }
}