import java.util.*;

public class Environment {
    private final Map<String, Object> variables;

    public Environment() {
        this.variables = new HashMap<>();
    }

    public Object get(String name) {
        // Si la variable no existe, tira error
        if (!variables.containsKey(name)) {
            throw new RuntimeException("Variable no definida: " + name);
        }
        return variables.get(name);
    }

    public void set(String name, Object value) {
        // Guarda la variable
        variables.put(name, value);
    }
}
