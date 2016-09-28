public class CestoDeLembas {
    private int quantidadeDeLembas;
    
    public CestoDeLembas(int quantidadeDeLembas) {
        this.quantidadeDeLembas = quantidadeDeLembas;
    }
    
    public boolean podeDividirEmPares() {
        if(quantidadeDeLembas%2 == 0 && quantidadeDeLembas/2 != 1)
            return true;
        return false;
    }
    
    public int getQuantidadeDeLembas() {
        return this.quantidadeDeLembas;
    }
}