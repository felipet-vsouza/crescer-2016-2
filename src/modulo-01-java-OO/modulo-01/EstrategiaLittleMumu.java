import java.util.*;

public class EstrategiaLittleMumu implements EstrategiaDeAtaque {
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, List<Dwarf> alvos) {
        ArrayList<Elfo> ordemDeAtaque = new ArrayList<>(), aptos = new ArrayList<>();
        for(Elfo e : atacantes) {
            if(e.getStatus().equals(Status.VIVO) && e.getFlecha().getQuantidade() > 0) {
                aptos.add(e);
            }
        }
        int tamanhoMaximo = (aptos.size() * 3) / 10;
        for(int i = 0; i < tamanhoMaximo; i++) {
            ordemDeAtaque.add(aptos.get(i));
        }
        return ordemDeAtaque;
    }
}