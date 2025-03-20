import java.util.*;

public class Evaluator {
    private final Environment env;

    public Evaluator() {
        this.env = new Environment();
    }

    public Object evaluate(ASTNode node) {
        // Si es un número o variable, devuelve su valor
        if (node.type.equals("atom")) {
            try {
                return Integer.parseInt(node.value); // Si es un número, lo convierte
            } catch (NumberFormatException e) {
                return env.get(node.value); // Si es variable, la busca en el entorno
            }
        } else {
            if (node.children.isEmpty()) {
                throw new RuntimeException("Expresión vacía no válida.");
            }

            // El primer elemento de la lista es el operador (+, -, *, /)
            String operator = node.children.get(0).value;
            List<Object> args = new ArrayList<>();

            // Evalúa cada argumento de la expresión
            for (int i = 1; i < node.children.size(); i++) {
                args.add(evaluate(node.children.get(i)));
            }

            // Aplica la operación matemática
            return applyOperator(operator, args);
        }
    }

    private Object applyOperator(String operator, List<Object> args) {
        // Verifica que todos los argumentos sean números
        if (args.stream().anyMatch(a -> !(a instanceof Integer))) {
            throw new RuntimeException("Operaciones solo soportan números.");
        }

        int result = (int) args.get(0);
        for (int i = 1; i < args.size(); i++) {
            int value = (int) args.get(i);

            // Realiza la operación según el operador recibido
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
