import java.util.*;
import java.util.regex.*;

public class Lexer {
    private final String input;
    private final List<String> tokens;

    public Lexer(String input) {
        this.input = input;
        this.tokens = new ArrayList<>();
    }

    public List<String> tokenize() {
        // Detectar paréntesis y operadores
        Pattern pattern = Pattern.compile("\\(|\\)|[\\w+\\-*/]+");
        Matcher matcher = pattern.matcher(input);

        // Extrae los tokens
        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        return tokens;
    }
}
