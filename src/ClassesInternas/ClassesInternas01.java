package ClassesInternas;

// --- 1. A CLASSE EXTERNA (Outer Class) ---

/**
 * Representa um Carro. Ela "contém" a lógica de Motor.
 */
    class Carro {
    
    // Campo privado da classe externa
    private String modelo;
    private int nivelCombustivel;
    
    // Instância da CLASSE INTERNA.
    // O Carro "tem um" Motor. A instância do Motor é criada
    // junto com a instância do Carro.
    private final Motor motor;

    public Carro(String modelo, int nivelCombustivel) {
        this.modelo = modelo;
        this.nivelCombustivel = nivelCombustivel;
        
        // Cria a instância do motor
        this.motor = new Motor();
    }
    
    /**
     * Método público do Carro que DELEGA a ação para o Motor.
     */
    public void ligar() {
        System.out.println("Tentando ligar o carro...");
        // Chama o método da classe interna
        motor.darPartida();
    }
    
    /**
     * Método público para abastecer o carro.
     */
    public void abastecer(int quantidade) {
        this.nivelCombustivel += quantidade;
        System.out.println("Abastecido. Nível atual: " + this.nivelCombustivel);
    }

    // --- 2. A CLASSE INTERNA (Inner Class) ---
    // 
    //
    // Esta classe é definida DENTRO da classe Carro.
    // Ela não é 'static', o que significa que uma instância de 'Motor'
    // SÓ PODE existir "ligada" a uma instância de 'Carro'.
    public class Motor {
        
        /**
         * Método da classe interna que demonstra o acesso
         * aos membros privados da classe externa.
         */
        public void darPartida() {
            // --- O SUPERPODER! ---
            // Acessando campos PRIVADOS ('nivelCombustivel' e 'modelo')
            // da classe externa 'Carro' diretamente!
            
            if (nivelCombustivel > 0) {
                
                System.out.println("Motor do " + modelo + " ligando... Vrum Vrum!");
                nivelCombustivel--; // Gasta um pouco de combustível
                
            } else {
                System.out.println("Sem combustível! Motor do " + modelo + " não pode ligar.");
            }
        }
    }
}


// --- 3. CLASSE DE TESTE (separada) ---

/**
 * Classe para testar o nosso Carro e seu Motor interno.
 */
public class ClassesInternas01 {
    public static void main(String[] args) {
        
        // 1. Uso normal
        Carro meuCarro = new Carro("Fusca", 0);
        
        // Tenta ligar sem combustível
        meuCarro.ligar(); // Saída: Sem combustível!
        
        System.out.println("---");
        
        // Abastece
        meuCarro.abastecer(5);
        
        // Tenta ligar de novo
        meuCarro.ligar(); // Saída: Motor do Fusca ligando...
        
        
        // --- 2. Sintaxe Especial (Instanciação Externa) ---
        // (Apenas para demonstração, menos comum)
        //
        // Você não pode fazer: Motor m = new Motor();
        // Porque o Motor precisa de uma instância de Carro para "viver".
        
        System.out.println("\n--- Instanciação Externa ---");
        Carro outroCarro = new Carro("Ferrari", 1);
        
        // A sintaxe para criar uma classe interna "de fora" é:
        // instanciaExterna.new ClasseInterna()
        Carro.Motor motorDaFerrari = outroCarro.new Motor();
        
        motorDaFerrari.darPartida();
    }
}