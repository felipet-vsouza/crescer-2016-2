public class Dwarf {
    private int hp;
    private DataTerceiraEra dataNascimento;
    private String nome;
    
    public Dwarf(){
        this.hp = 110;
    }
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public void recebeDano(int dano){
        this.hp -= dano;
    }
    
    public int getHp(){
        return this.hp;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public DataTerceiraEra getDataNascimento() {
        return this.dataNascimento;
    }
}