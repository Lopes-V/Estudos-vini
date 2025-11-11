package Coleções;
public class BinarySearch01 {

    /**
     * O método principal que executa a busca binária.
     *
     * @param array O array ORDENADO onde vamos procurar.
     * @param alvo O valor (target) que estamos tentando encontrar.
     * @return O índice (posição) do alvo, ou -1 se não for encontrado.
     */
    public static int realizarBuscaBinaria(int[] array, int alvo) {
        
        // 1. Definir os limites da nossa "área de busca".
        // Começamos com o array inteiro.
        int baixo = 0; // O índice mais à esquerda (início).
        int alto = array.length - 1; // O índice mais à direita (fim).

        // 2. O loop de busca.
        // Continuamos buscando enquanto nossa "área de busca" for válida
        // (ou seja, enquanto o 'baixo' não ultrapassar o 'alto').
        while (baixo <= alto) {
            
            // 3. Encontrar o meio da área de busca atual.
            // Usamos divisão inteira (o (int) é implícito).
            // Ex: Se baixo=0 e alto=9, meio = (0+9)/2 = 4.
            int meio = (baixo + alto) / 2;
            
            // 4. Pegar o valor que está no "meio" (nosso "chute").
            int chute = array[meio];

            // 5. Comparar o "chute" com o "alvo".
            
            // --- CASO 1: ACHAMOS! ---
            if (chute == alvo) {
                // O valor no meio é exatamente o que procurávamos.
                return meio; // Retornamos o índice.
            } 
            
            // --- CASO 2: O chute foi muito baixo ---
            else if (chute < alvo) {
                // Se o chute (ex: 50) é menor que o alvo (ex: 75),
                // sabemos que o alvo SÓ PODE estar na metade DIREITA.
                //
                // 
                //
                // Descartamos toda a metade esquerda,
                // movendo nosso limite 'baixo' para UMA POSIÇÃO *depois* do 'meio'.
                baixo = meio + 1;
            } 
            
            // --- CASO 3: O chute foi muito alto ---
            else { // (chute > alvo)
                // Se o chute (ex: 50) é maior que o alvo (ex: 25),
                // sabemos que o alvo SÓ PODE estar na metade ESQUERDA.
                //
                // 
                //
                // Descartamos toda a metade direita,
                // movendo nosso limite 'alto' para UMA POSIÇÃO *antes* do 'meio'.
                alto = meio - 1;
            }
            
            // O loop 'while' recomeça, mas agora com uma "área de busca"
            // (entre 'baixo' e 'alto') que é a metade da anterior.
        }

        // 6. Não encontrado.
        // Se o loop terminar (porque 'baixo' ultrapassou 'alto'),
        // significa que reviramos o array e o alvo não existe.
        // Retornamos -1 (uma convenção comum para "não encontrado").
        return -1;
    }

    // --- Método main() apenas para testar ---
    public static void main(String[] args) {
        // OBRIGATÓRIO: O array deve estar ordenado.
        int[] numerosOrdenados = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        
        int alvo1 = 23;
        int alvo2 = 5;
        int alvo3 = 99; // (Este não existe)

        // Teste 1: Encontrar o 23
        int indice1 = realizarBuscaBinaria(numerosOrdenados, alvo1);
        System.out.println("Alvo " + alvo1 + " encontrado no índice: " + indice1); // Saída: ... índice: 5

        // Teste 2: Encontrar o 5
        int indice2 = realizarBuscaBinaria(numerosOrdenados, alvo2);
        System.out.println("Alvo " + alvo2 + " encontrado no índice: " + indice2); // Saída: ... índice: 1

        // Teste 3: Não encontrar o 99
        int indice3 = realizarBuscaBinaria(numerosOrdenados, alvo3);
        System.out.println("Alvo " + alvo3 + " encontrado no índice: " + indice3); // Saída: ... índice: -1
    }
}