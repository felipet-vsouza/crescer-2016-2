import java.util.*;
import java.util.stream.*;

public class EstrategiaAtaqueIntercalado implements EstrategiaDeAtaque {
    

    public List<Elfo> getOrdemDeAtaque(List<Elfo> elfos, List<Dwarf> dwarves) throws ContingenteDesproporcionalException {
        ArrayList<Elfo> ordemDeAtaque = new ArrayList<>();
        List<Elfo> elfosVivos = new ArrayList<>();
        int verdes = 0, noturnos = 0;
        Class primeiroElfo = null;
        for(Elfo e : elfos) {
            if(primeiroElfo == null && e.getStatus().equals(Status.VIVO)) {
                primeiroElfo = e.getClass();
            }
            if(e instanceof ElfoVerde) {
                verdes++;
            } else {
                noturnos++;
            }
            elfosVivos.add(e);
        }
        if(verdes != noturnos) {
            throw new ContingenteDesproporcionalException();
        }
        int ultimoDiferente = 0;
        for(int i = 0; i < elfosVivos.size(); i++) {
            Elfo elfo = elfosVivos.get(i);
            if(elfo.getClass().isAssignableFrom(primeiroElfo)) {
                ordemDeAtaque.add(elfo);
                for(int j = ultimoDiferente; j < elfosVivos.size(); j++) {
                    Elfo elfo2 = elfosVivos.get(j);
                    if(!(elfo2.getClass().isAssignableFrom(primeiroElfo))) {
                        ordemDeAtaque.add(elfo2);
                        ultimoDiferente = j;
                        break;
                    }
                }
            }
        }
        return ordemDeAtaque;
    }
}