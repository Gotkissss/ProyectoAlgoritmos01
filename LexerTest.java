import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LexerTest {
    @Test
    void testTokenizeSimpleExpression() {
        Lexer lexer = new Lexer("(+ 1 2)");
        List<String> tokens = lexer.tokenize();
        assertEquals(List.of("(", "+", "1", "2", ")"), tokens);
    }

    @Test
    void testTokenizeNestedExpression() {
        Lexer lexer = new Lexer("(+ (* 2 3) 4)");
        List<String> tokens = lexer.tokenize();
        assertEquals(List.of("(", "+", "(", "*", "2", "3", ")", "4", ")"), tokens);
    }
}
