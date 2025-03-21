import java.util.*;

public class Environment<T> {
    private Map<String, T> variables;

    public Environment() {
        this.variables = new HashMap<>();
    }

    public T get(String name) {
        // Si la variable no existe, tira error
        if (!variables.containsKey(name)) {
            throw new RuntimeException("Variable no definida: " + name);
        }
        return variables.get(name);  // Retorna un valor del tipo T
    }

    public void set(String name, T value) {
        variables.put(name, value);  // Asigna un valor de tipo T
    }
}
