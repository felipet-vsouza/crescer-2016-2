import java.util.*;
import java.util.stream.*;

public class EstrategiaNoturnosPorUltimo implements EstrategiaDeAtaque {
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, List<Dwarf> alvos) {
        ArrayList<Elfo> ordemDeAtaque = new ArrayList<>();
        ordemDeAtaque.addAll(atacantes
            .stream()
            .filter(e -> e instanceof ElfoVerde && e.getStatus().equals(Status.VIVO))
            .collect(Collectors.toList()));
        ordemDeAtaque.addAll(atacantes
            .stream()
            .filter(e -> e instanceof ElfoNoturno && e.getStatus().equals(Status.VIVO))
            .collect(Collectors.toList()));
        return ordemDeAtaque;
    }
}