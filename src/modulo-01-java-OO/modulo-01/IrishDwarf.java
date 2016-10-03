public class IrishDwarf extends Dwarf {
    
    public IrishDwarf() {
        this(null, new DataTerceiraEra(1, 1, 1));
    }

    public IrishDwarf(String nome, DataTerceiraEra dataNascimento){
        super(nome, dataNascimento);
    }

    public void tentarSorte() {
        if(this.getNumeroSorte() == -3333.) {
            this.inventario.aumentarMuitoUnidadesDosItens(1000);
        }
    }
}