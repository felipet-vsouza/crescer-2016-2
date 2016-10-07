import java.util.List;

public interface EstrategiaDeAtaque
{
    List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, List<Dwarf> alvos);
}
