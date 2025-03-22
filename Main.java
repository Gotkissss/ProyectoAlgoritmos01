import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Evaluator evaluator = new Evaluator();  // Mantiene el entorno entre ejecuciones
        
        System.out.println("Intérprete Lisp en Java. Escribe 'exit' para salir.");
        
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                // Tokenización
                Lexer lexer = new Lexer(input);
                List<String> tokens = lexer.tokenize();

                // Parseo
                Parser parser = new Parser();
                ASTNode ast = parser.parse(tokens);

                // Evaluación
                Object result = evaluator.evaluate(ast);
                System.out.println("Resultado: " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Programa terminado.");
    }
}
