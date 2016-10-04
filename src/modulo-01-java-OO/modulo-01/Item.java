public class Item {
    private String descricao;
    private int quantidade;
    
    public Item(String descricao, int quantidade) {
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    public void aumentarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }
    
    public void setQuantidade(int novaQuantidade) {
        quantidade = novaQuantidade;
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    @Override
    public boolean equals(Object obj) {
        Item item;
        if(obj != null && obj instanceof Item)
            item = (Item) obj;
        else
            return false;
        return 
            item.getDescricao().equals(this.descricao) && 
            item.getQuantidade() == this.quantidade;
    }
}







