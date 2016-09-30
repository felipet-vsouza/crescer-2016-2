import java.util.ArrayList;

public class HobbitContador {
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDePares) {
        ArrayList<Integer> produto = new ArrayList<>();
        ArrayList<Integer> mmc = new ArrayList<>();
        ArrayList<Integer> diferenca = new ArrayList<>();
        for(int i = 0; i < arrayDePares.size(); i++) {
            ArrayList<Integer> pares = arrayDePares.get(i);
            int num1 = pares.get(0);
            int num2 = pares.get(1);
            mmc.add(minimoMultiploComum(num1, num2));
            produto.add(num1 * num2);
        }
        for(int i = 0; i < mmc.size(); i++) {
            
        }
    }

    private int minimoMultiploComum(int a, int b)
    {
        return a * (b / maximoMultiploComum(a, b));
    }

    private int maximoDivisorComum(int a, int b)
    {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}