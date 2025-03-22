import java.util.*;

<<<<<<< HEAD
public class Environment {
    private final Map<String, Object> variables;
    private final Map<String, FunctionDef> functions;  
=======
public class Environment<T> {
    private Map<String, T> variables;
>>>>>>> 07d1e9dc6596b3dbdccd9789632fcd86b7c6399c

    public Environment() {
        this.variables = new HashMap<>();
        this.functions = new HashMap<>();
    }

<<<<<<< HEAD
    public Object get(String name) {
        if (variables.containsKey(name)) {
            return variables.get(name);
        }
        throw new RuntimeException("Variable no definida: " + name);
    }

    public void set(String name, Object value) {
        variables.put(name, value);
=======
    public T get(String name) {
        // Si la variable no existe, tira error
        if (!variables.containsKey(name)) {
            throw new RuntimeException("Variable no definida: " + name);
        }
        return variables.get(name);  // Retorna un valor del tipo T
    }

    public void set(String name, T value) {
        variables.put(name, value);  // Asigna un valor de tipo T
>>>>>>> 07d1e9dc6596b3dbdccd9789632fcd86b7c6399c
    }

    public void defineFunction(String name, FunctionDef function) {
        functions.put(name, function);
    }

    public FunctionDef getFunction(String name) {
        return functions.get(name);
    }
}
