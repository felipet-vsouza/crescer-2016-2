public class Dwarf {
    private int hp;
    private DataTerceiraEra dataNascimento;
    private String nome;
    private int exp;
    private Status status;
    
    {
        this.hp = 110;
    }
    
    public Dwarf(){
        this(null, new DataTerceiraEra(1, 1, 1));
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.status = Status.VIVO;
    }

    public void recebeDano(int dano) {
        double numeroSorte = this.getNumeroSorte();
        if(numeroSorte > 100)
            if(this.hp >= dano)
                this.hp -= dano;
            else
                this.hp = 0;
        else if(numeroSorte < 0)
            this.exp += 2;
        if(this.hp == 0)
            this.status = Status.MORTO;
    }

    public double getNumeroSorte() {
        double numero = 101.0;
        if(this.dataNascimento.ehBissexto() && this.hp >= 80 && this.hp <= 90)
            numero *= -33;
        if(!this.dataNascimento.ehBissexto() && ("Seixas".equals(this.nome) || "Meireles".equals(this.nome)))
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
    
    public Status getStatus() {
        return this.status;
    }
}