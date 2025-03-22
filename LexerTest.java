import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LexerTest {
    @Test
    public void testTokenize() {
        Lexer lexer = new Lexer("(+ 2 3)");
        List<String> tokens = lexer.tokenize();
        assertEquals(List.of("(", "+", "2", "3", ")"), tokens);
    }

    @Test
    public void testTokenizeWithNestedExpression() {
        Lexer lexer = new Lexer("(+ (* 2 3) 4)");
        List<String> tokens = lexer.tokenize();
        assertEquals(List.of("(", "+", "(", "*", "2", "3", ")", "4", ")"), tokens);
    }
}
