import java.util.*;

public class ElfoVerde extends Elfo {
    public ElfoVerde(String nome) {
        super(nome);
    }

    public ElfoVerde(String nome, int quantidadeFlechas) {
        super(nome, quantidadeFlechas);
    }

    @Override
    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlecha(dwarf, 2);
    }

    @Override
    public void adicionarItem(Item item) {
        String[] validos = {"Espada de aço valiriano", "Arco de Vidro", "Flecha de Vidro"};
        if(item != null && new ArrayList<>(Arrays.asList(validos)).contains(item.getDescricao())) {
            super.adicionarItem(item);
        }
    }

    @Override
    public void inicializarInventario(int quantidadeFlechas) {
        this.inventario.adicionarItem(new Item("Arco de Vidro", 1));
        this.inventario.adicionarItem(new Item("Flecha de Vidro", quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
        this.inventario.adicionarItem(new Item("Espada de aço valiriano", 1));
    }
}