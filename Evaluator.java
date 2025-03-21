import java.util.*;

public class Evaluator {
    private final Environment env;

    public Evaluator() {
        this.env = new Environment();
    }

    public int evaluate(ASTNode node) {
        if (node.type.equals("atom")) {
            return Integer.parseInt(node.value); // Convierte directamente a int
        } else {
            if (node.children.isEmpty()) {
                throw new RuntimeException("Expresión vacía no válida.");
            }

            String operator = node.children.get(0).value;
            int result = evaluate(node.children.get(1));

            for (int i = 2; i < node.children.size(); i++) {
                int value = evaluate(node.children.get(i));
                switch (operator) {
                    case "+": result += value; break;
                    case "-": result -= value; break;
                    case "*": result *= value; break;
                    case "/":
                        if (value == 0) throw new ArithmeticException("División por cero.");
                        result /= value;
                        break;
                    default:
                        throw new RuntimeException("Operador no soportado: " + operator);
                }
            }
            return result;
        }
    }


    private int applyOperator(String operator, List<Integer> args) {
        // Verifica que todos los argumentos sean números (ya que la lista es de enteros, esta validación no es necesaria)
        int result = args.get(0);  // El primer valor es el resultado inicial

        // Itera sobre los demás valores en la lista
        for (int i = 1; i < args.size(); i++) {
            int value = args.get(i);

            // Realiza la operación según el operador recibido
            switch (operator) {
                case "+":
                    result += value;
                    break;
                case "-":
                    result -= value;
                    break;
                case "*":
                    result *= value;
                    break;
                case "/":
                    if (value == 0) throw new ArithmeticException("División por cero.");
                    result /= value;
                    break;
                default:
                    throw new RuntimeException("Operador no soportado: " + operator);
            }
        }

        return result;
    }
}
