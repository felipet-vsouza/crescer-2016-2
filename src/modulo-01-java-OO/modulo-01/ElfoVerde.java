public class ElfoVerde extends Elfo {
    public ElfoVerde(String nome) {
        super(nome);
    }
    
    public ElfoVerde(String nome, int quantidadeFlechas) {
        super(nome, quantidadeFlechas);
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlecha(dwarf);
        exp++;
    }
    
    public void adicionarItem(Item item) {
        String descricao = item.getDescricao();
        if(descricao.equals("Espada de aço valiriano") || descricao.equals("Arco e Flecha de Vidro")) {
            super.adicionarItem(item);
        }
    }
}