public class Scanner01 {
    public static void main(String[] args) {
        // 1. Define uma única String que contém vários valores separados por vírgula.
        //    Note que há espaços em branco após as vírgulas.
        String nome = "nome1, nome2, nome3, nome4, 123";

        // 2. Usa o método split(",") para "quebrar" a String original em um array de Strings. ✂️
        //    O caractere ',' é o delimitador, ou seja, o ponto onde a quebra ocorre.
        //    Após esta linha, o array 'nomes' conterá: ["nome1", " nome2", " nome3", " nome4", " 123"]
        String[] nomes = nome.split(",");

        // 3. Usa um "enhanced for-loop" (ou "for-each") para percorrer cada item do array 'nomes'.
        for (String nome1 : nomes) {
            // 4. Para cada item, imprime o resultado do método trim().
            //    O método trim() remove todos os espaços em branco do início e do fim da String. 🧹
            //    Isso é crucial para limpar os " nome2", " nome3", etc., que ficaram com um espaço extra após o split.
            System.out.println(nome1.trim());
        }
    }
}