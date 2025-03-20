import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EvaluatorTest {
    @Test
    void testEvaluateSimpleExpression() {
        Lexer lexer = new Lexer("(+ 1 2)");
        List<String> tokens = lexer.tokenize();
        LispParser parser = new LispParser(tokens);
        ASTNode ast = parser.parse();
        Evaluator evaluator = new Evaluator();
        Object result = evaluator.evaluate(ast);
        assertEquals(3, result);
    }

    @Test
    void testEvaluateNestedExpression() {
        Lexer lexer = new Lexer("(+ (* 2 3) 4)");
        List<String> tokens = lexer.tokenize();
        LispParser parser = new LispParser(tokens);
        ASTNode ast = parser.parse();
        Evaluator evaluator = new Evaluator();
        Object result = evaluator.evaluate(ast);
        assertEquals(10, result);
    }

    @Test
    void testEvaluateDivisionByZero() {
        Lexer lexer = new Lexer("(/ 1 0)");
        List<String> tokens = lexer.tokenize();
        LispParser parser = new LispParser(tokens);
        ASTNode ast = parser.parse();
        Evaluator evaluator = new Evaluator();
        assertThrows(ArithmeticException.class, () -> evaluator.evaluate(ast));
    }
}
