public class Dwarf extends Personagem {
    protected DataTerceiraEra dataNascimento;
    
    {
        this.hp = 110;
    }

    public Dwarf(){
        this(null, new DataTerceiraEra(1, 1, 1));
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        super(nome);
        this.dataNascimento = dataNascimento;
    }

    public void recebeDano(int dano) {
        if(this.status.equals(Status.MORTO)){
            return;
        }
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
    
    public void tentarSorte() {
        if(this.getNumeroSorte() == -3333.) {
            this.inventario.aumentarUnidadesDosItens(1000);
        }
    }

    public DataTerceiraEra getDataNascimento() {
        return this.dataNascimento;
    }
}