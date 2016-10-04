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
        String[] validos = {"Espada de aço valiriano", "Arco e Flecha de Vidro"};
        if(item != null && new ArrayList<>(Arrays.asList(validos)).contains(item.getDescricao())) {
            super.adicionarItem(item);
        }
    }
}