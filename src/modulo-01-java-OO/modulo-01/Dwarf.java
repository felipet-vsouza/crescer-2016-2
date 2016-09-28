public class Dwarf {
    private String nome;
    private int hp;
    
    public Dwarf (String nome){
        this.nome = nome;
        this.hp = 110;
    }
    
    public void recebeDano(int dano){
        this.hp -= dano;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getHP(){
        return this.hp;
    }
}