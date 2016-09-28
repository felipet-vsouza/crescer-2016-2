public class Dwarf {
    private int hp;
    
    public Dwarf (){
        this.hp = 110;
    }
    
    public void recebeDano(int dano){
        this.hp -= dano;
    }
    
    public int getHp(){
        return this.hp;
    }
}