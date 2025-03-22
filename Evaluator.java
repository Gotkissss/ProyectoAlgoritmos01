import java.util.ArrayList;
import java.util.List;

public class Evaluator {
    private final Environment env;

    public Evaluator() {
        this.env = new Environment();
    }

<<<<<<< HEAD
    public Object evaluate(ASTNode node) {
        if (node.type.equals("atom")) {
            try {
                return Integer.parseInt(node.value);
            } catch (NumberFormatException e) {
                return env.get(node.value);
            }
        } else if (node.type.equals("expression")) {
            if (node.children.isEmpty()) {
                throw new RuntimeException("Expresión vacía no válida.");
            }
            String operator = node.children.get(0).value;
            if (operator.equals("DEFUN")) {
                return defineFunction(node);
            } else if (operator.equals("COND")) {
                return evaluateCond(node);
            } else {
                return applyFunction(operator, node.children.subList(1, node.children.size()));
            }
=======
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
>>>>>>> 07d1e9dc6596b3dbdccd9789632fcd86b7c6399c
        }
        throw new RuntimeException("Expresión inválida: " + node);
    }

<<<<<<< HEAD
    private Object defineFunction(ASTNode node) {
        if (node.children.size() < 3) {
            throw new RuntimeException("DEFUN necesita al menos un nombre, parámetros y un cuerpo.");
        }
        
        String functionName = node.children.get(0).value;
        List<String> parameters = new ArrayList<>();
        
        for (ASTNode param : node.children.get(1).children) {
            parameters.add(param.value);
        }
        
        ASTNode body = node.children.get(2);
        env.defineFunction(functionName, new FunctionDef(parameters, body));
        return "Función " + functionName + " definida.";
    }

    private Object evaluateCond(ASTNode node) {
        for (ASTNode clause : node.children.subList(1, node.children.size())) {
            Object condition = evaluate(clause.children.get(0));
            if ((condition instanceof Integer && (Integer) condition != 0) || condition.equals(true)) {
                return evaluate(clause.children.get(1));
            }
        }
        return null;
    }

    private Object applyFunction(String functionName, List<ASTNode> args) {
        FunctionDef function = env.getFunction(functionName);
        if (function == null) {
            throw new RuntimeException("Función no definida: " + functionName);
        }
        if (function.parameters.size() != args.size()) {
            throw new RuntimeException("Cantidad incorrecta de argumentos para " + functionName);
        }

        Environment localEnv = new Environment();
        for (int i = 0; i < args.size(); i++) {
            localEnv.set(function.parameters.get(i), evaluate(args.get(i)));
        }

        Evaluator localEvaluator = new Evaluator();
        return localEvaluator.evaluate(function.body);
=======

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
>>>>>>> 07d1e9dc6596b3dbdccd9789632fcd86b7c6399c
    }
}
