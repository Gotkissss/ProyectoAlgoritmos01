import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una expresión Lisp:");
        String input = scanner.nextLine();
        scanner.close();

        // Tokenización
        Lexer lexer = new Lexer(input);
        List<String> tokens = lexer.tokenize();
        System.out.println("Tokens: " + tokens);

        // Parseo)
        Parser parser = new Parser();
        ASTNode ast = parser.parse(tokens);
        System.out.println("AST generado: " + ast);

        // Evaluación
        Evaluator evaluator = new Evaluator();
        Object result = evaluator.evaluate(ast);
        System.out.println("Resultado: " + result);
    }
}
