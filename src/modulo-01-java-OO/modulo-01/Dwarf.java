public class Dwarf {
    private int hp;
    private DataTerceiraEra dataNascimento;
    private String nome;
    private int exp;
    private Status status;
    private Inventario inventario;

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
        this.inventario = new Inventario();
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
    
    public void adicionarItem(Item item) {
        this.inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item) {
        this.inventario.removerItem(item);
    }
    
    public Inventario getInventario() {
        return this.inventario;
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