import java.util.*;

public class Environment {
    private final Map<String, Object> variables;

    public Environment() {
        this.variables = new HashMap<>();
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
}
