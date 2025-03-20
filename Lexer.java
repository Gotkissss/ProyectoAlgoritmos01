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
        Pattern pattern = Pattern.compile("\\(|\\)|[\\w+\\-*/]+");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        return tokens;
    }
}
