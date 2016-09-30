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
        this.lista.remove(item);
    }

    public String getDescricoesItens() {
        String retorno = "";
        for(int i = 0; i < this.lista.size(); i++) {
            String descricao = this.lista.get(i).getDescricao();
            retorno += descricao + (i == this.lista.size() - 1 ? "" : ",");
        }
        return retorno;
    }

    public Item getItemMaisPopular() {
        Item item = null;
        int maiorQuantidade = 0;
        for(int i = 0; i < this.lista.size(); i++){
            Item itemDaLista = this.lista.get(i);
            if(itemDaLista.getQuantidade() > maiorQuantidade){
                maiorQuantidade = itemDaLista.getQuantidade();
                item = itemDaLista;
            }
        }
        return item;
    }

    public ArrayList<Item> getLista() {
        return this.lista;
    }

    public void aumentarUnidadesDosItens(int quantidade) {
        for(Item item : this.lista){
            item.aumentarQuantidade(quantidade);
        }
    }

    public void ordenarItens() {
        for(int i = 0; i < this.lista.size() - 1; i++){
            int indiceMenorQuantidade = i;
            for(int j = i + 1; j < this.lista.size(); j++){
                if(this.lista.get(indiceMenorQuantidade).getQuantidade() > this.lista.get(j).getQuantidade()){
                    indiceMenorQuantidade = j;
                }
            }
            if(i != indiceMenorQuantidade) {
                Item maior = this.lista.get(i);
                Item menor = this.lista.get(indiceMenorQuantidade);
                this.lista.remove(i);
                this.lista.add(i, menor);
                this.lista.remove(indiceMenorQuantidade);
                this.lista.add(indiceMenorQuantidade, maior);
            }
        }
    }
}