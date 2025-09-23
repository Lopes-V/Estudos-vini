package Variaveis;

// Declaração da classe principal.
public class TiposVariaveis {
    // Método principal, o ponto de entrada da aplicação.
    public static void main(String[] args) {
        // Declara uma variável chamada 'number' do tipo Integer.
        // Integer é uma classe "wrapper" para o tipo primitivo 'int'.
        // Ele permite que um número inteiro seja tratado como um objeto.
        Integer number;
        // Atribui o valor 2 à variável 'number'.
        number = 2;

        // Declara uma variável chamada 'name' do tipo String, para armazenar uma sequência de caracteres.
        String name;
        // Atribui o texto "Vinicius" à variável 'name'. Strings em Java são imutáveis.
        name = "Vinicius";

        // Cria um objeto StringBuilder, que é uma sequência de caracteres MUTÁVEL.
        // É mais eficiente para concatenar (juntar) muitas strings, pois não cria novos objetos a cada modificação.
        StringBuilder nameBuilder = new StringBuilder();
        // Adiciona o texto "Vinicius" ao objeto StringBuilder.
        nameBuilder.append("Vinicius");

        // Cria um objeto StringBuffer, que também é uma sequência de caracteres MUTÁVEL.
        // É semelhante ao StringBuilder, mas é "thread-safe" (sincronizado),
        // sendo seguro para uso em ambientes com múltiplas threads, mas ligeiramente mais lento.
        StringBuffer nameBuffer = new StringBuffer();
        // Adiciona o texto "Vinicius" ao objeto StringBuffer.
        nameBuffer.append("Vinicius");

        // Declara uma variável chamada 'bool' do tipo Boolean.
        // Boolean é a classe "wrapper" para o tipo primitivo 'boolean'.
        Boolean bool;
        // Atribui o valor booleano 'true' (verdadeiro) à variável.
        bool = true;

        // Declara uma variável chamada 'caracter' do tipo Character.
        // Character é a classe "wrapper" para o tipo primitivo 'char'.
        Character caracter;
        // Atribui o caractere único 'V' à variável. Caracteres são definidos com aspas simples (' ').
        caracter = 'V';
    }
}