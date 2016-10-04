public class ElfoNoturno extends Elfo {
    public ElfoNoturno(String nome) {
        super(nome);
    }
    
    public ElfoNoturno(String nome, int quantidadeFlechas) {
        super(nome, quantidadeFlechas);
    }
    
    @Override
    public void atirarFlecha(Dwarf dwarf){
        //this.hp = this.hp - ((this.hp * 5) / 100);
        // Desta forma não funciona, pois, uma vez que o Java trata o número como inteiro e sempre 
        // arredonda o resultado para baixo, o resultado do cálculo de 5% a partir do número 19 será 0
        // e nada mais será subtraído.
        if (status == Status.VIVO) { 
            super.atirarFlecha(dwarf, 3); 
            this.hp *= 0.95; 
            this.status = (int)this.hp == 0 ? Status.MORTO : this.status; 
        } 
    }
}