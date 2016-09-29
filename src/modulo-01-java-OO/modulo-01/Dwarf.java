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
    
    public double getNumeroSorte() {
        double numero = 101.0;
        if(this.dataNascimento.ehBissexto() && this.hp >= 80 && this.hp <= 90)
            numero *= -33;
        if(!this.dataNascimento.ehBissexto() && (this.nome.equals("Seixas") || this.nome.equals("Meireles"))){
            numero *= 33;
            numero = numero % 100;
        }
        return numero;
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