import java.util.*;

public class Environment {
    private final Map<String, Object> variables;
    private final Map<String, FunctionDef> functions;  

    public Environment() {
        this.variables = new HashMap<>();
        this.functions = new HashMap<>();
    }

    public Object get(String name) {
        if (!variables.containsKey(name)) {
            throw new RuntimeException("Variable no definida: " + name);
        }
        return variables.get(name);
    }

    public void set(String name, Object value) {
        variables.put(name, value);
    }

    public void defineFunction(String name, FunctionDef function) {
        functions.put(name, function);
    }

    public FunctionDef getFunction(String name) {
        return functions.get(name);
    }
}
