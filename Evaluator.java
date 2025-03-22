import java.util.ArrayList;
import java.util.List;

public class Evaluator {
    private final Environment env;

    public Evaluator() {
        this.env = new Environment();
    }

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
                List<Integer> evaluatedArgs = new ArrayList<>();
                for (ASTNode child : node.children.subList(1, node.children.size())) {
                    evaluatedArgs.add((Integer) evaluate(child));
                }
                return applyOperator(operator, evaluatedArgs);
            }
        }
        throw new RuntimeException("Expresión inválida: " + node);
    }

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

    private int applyOperator(String operator, List<Integer> args) {
        int result = args.get(0);
        for (int i = 1; i < args.size(); i++) {
            int value = args.get(i);
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