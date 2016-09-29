public class Dwarf {
    private int hp;
    private DataTerceiraEra dataNascimento;
    private String nome;
    private int exp;

    public Dwarf(){
        this.hp = 110;
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public void recebeDano(int dano){
        double numeroSorte = this.getNumeroSorte();
        if(numeroSorte > 100)
            this.hp -= dano;
        else if(numeroSorte < 0)
            this.exp += 2;
    }

    public double getNumeroSorte() {
        double numero = 101.0;
        if(this.dataNascimento.ehBissexto() && this.hp >= 80 && this.hp <= 90)
            numero *= -33;
        if(!this.dataNascimento.ehBissexto() && (this.nome.equals("Seixas") || this.nome.equals("Meireles")))
            numero = numero * 33 % 100;
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
    
    public int getExp() {
        return this.exp;
    }
}