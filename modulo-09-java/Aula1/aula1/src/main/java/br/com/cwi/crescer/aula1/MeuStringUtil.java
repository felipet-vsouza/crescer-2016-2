package br.com.cwi.crescer.aula1;

public class MeuStringUtil {

    public static void main(String[] args) {
        System.out.println("Recursos disponíveis:");
        System.out.println("Validação de string vazia: isVazia(String)");
        System.out.println("Contagem de vogais: contarVogais(String)");
        System.out.println("Inversão: inverter(String)");
        System.out.println("Verificação de palíndromo: isPalindromo(String)");
    }
    
    public static boolean isVazia(String ref) {
        if(ref != null)
            return ref.equals("");
        return true;
    }

    public static int contarVogais(String ref) {
        int total = 0;
        for (char c : ref.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                total++;
            }
        }
        return total;
    }

    public static String inverter(String ref) {
        String invertida = "";
        char[] array = ref.toCharArray();
        for (int x = array.length - 1; x >= 0; x--) {
            invertida += array[x];
        }
        return invertida;
    }

    public static boolean isPalindromo(String ref) {
        ref = ref.toLowerCase()
                .replaceAll(" ", "")
                .replaceAll("[áàäâã]", "a")
                .replaceAll("[éèëê]", "e")
                .replaceAll("[íìïî]", "i")
                .replaceAll("[óòöôõ]", "o")
                .replaceAll("[úùüû]", "u");
        char[] invertido = inverter(ref).toCharArray();
        char[] referencia = ref.toCharArray();
        for (int i = 0; i < referencia.length; i++) {
            if (referencia[i] != invertido[i]) {
                return false;
            }
        }
        return true;
    }
}
