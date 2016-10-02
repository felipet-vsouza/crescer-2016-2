import java.util.ArrayList;

public class HobbitContador {
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDePares) {
        int soma = 0;
        for(int i = 0; i < arrayDePares.size(); i++) {
            ArrayList<Integer> pares = arrayDePares.get(i);
            int num1 = pares.get(0);
            int num2 = pares.get(1);
            soma += (num1 * num2) - minimoMultiploComum(num1, num2);
        }
        return soma;
    }

    private int minimoMultiploComum(int a, int b)
    {
        return a == 0 && b == 0 ? 0 : a * (b / maximoDivisorComum(a, b));
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