package generics;

// 1. DEFINIÇÃO DA CLASSE GENÉRICA

// Aqui, "<T>" é um "parâmetro de tipo" (Type parameter).
// É um marcador de posição. Estamos dizendo: "Esta classe vai
// trabalhar com um tipo 'T', mas eu ainda não sei qual é.
// O usuário dirá qual é o tipo 'T' quando criar a Caixa."
// 
class Caixa<T> {

    // Em vez de usar "private String item;" ou "private Object item;",
    // usamos "private T item;".
    // Se o usuário criar uma Caixa<String>, 'T' será String.
    // Se criar uma Caixa<Integer>, 'T' será Integer.
    private T item;

    // O método 'setItem' agora espera um item do tipo 'T'
    public void setItem(T item) {
        this.item = item;
    }

    // O método 'getItem' agora retorna um item do tipo 'T'
    public T getItem() {
        return this.item;
    }
    
    @Override
    public String toString() {
        // 'item.getClass().getName()' mostra o tipo real de 'T'
        return "Caixa guardando um [" + item.getClass().getName() + "] com valor: " + item;
    }
}

// 2. CLASSE PRINCIPAL PARA TESTAR A CAIXA

public class Generics01 {
    public static void main(String[] args) {

        System.out.println("--- 📦 Testando Caixa<String> ---");
        
        // --- Uso com String ---
        // Aqui, especificamos que o 'T' da nossa Caixa será 'String'.
        // O Java substitui todo 'T' por 'String' *nesta instância*.
        Caixa<String> caixaDeTexto = new Caixa<>();
        
        // O método setItem(T item) agora espera uma String.
        caixaDeTexto.setItem("Olá, Generics!");
        
        // O método getItem() agora retorna uma String.
        // **NÃO PRECISAMOS DE CAST!** (ex: (String) getItem())
        String meuTexto = caixaDeTexto.getItem();
        
        System.out.println(meuTexto);
        System.out.println(caixaDeTexto); // Chama o toString()
        
        // ---------------------------------------------------
        // O PODER DO COMPILADOR:
        // Se tentarmos colocar um Integer em uma Caixa<String>,
        // o código NEM COMPILA. Isso é a "Segurança de Tipo" (Type Safety).
        //
        // caixaDeTexto.setItem(123); // <-- Erro de Compilação! Ótimo!
        // ---------------------------------------------------

        System.out.println("\n--- 📦 Testando Caixa<Integer> ---");

        // --- Reutilização com Integer ---
        // Estamos REUTILIZANDO a *mesma* classe Caixa.
        // Desta vez, 'T' será 'Integer'.
        Caixa<Integer> caixaDeNumero = new Caixa<>();

        // O método setItem(T item) agora espera um Integer.
        caixaDeNumero.setItem(100);
        
        // O método getItem() agora retorna um Integer.
        // **NOVAMENTE, SEM CAST!**
        Integer meuNumero = caixaDeNumero.getItem();
        
        System.out.println("Número guardado: " + meuNumero);
        System.out.println(caixaDeNumero);
    }
}