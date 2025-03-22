import static org.junit.jupiter.api.Assertions.*;
<<<<<<< HEAD
import org.junit.jupiter.api.Test;
=======
import java.util.List;
>>>>>>> 07d1e9dc6596b3dbdccd9789632fcd86b7c6399c

public class EvaluatorTest {
    @Test
<<<<<<< HEAD
    public void testEvaluateNumber() {
        Evaluator evaluator = new Evaluator();
        ASTNode node = new ASTNode("atom", "42");
        assertEquals(42, evaluator.evaluate(node));
    }

    @Test
    public void testEvaluateUndefinedVariable() {
        Evaluator evaluator = new Evaluator();
        ASTNode node = new ASTNode("atom", "x");
        assertThrows(RuntimeException.class, () -> evaluator.evaluate(node));
=======
    void testEvaluateSimpleExpression() {
        Lexer lexer = new Lexer("(+ 1 2)");
        List<String> tokens = lexer.tokenize();
        Parser parser = new Parser();
        ASTNode ast = parser.parse(tokens);
        Evaluator evaluator = new Evaluator();
        int result = (int) evaluator.evaluate(ast);
        assertEquals(3, result);
    }

    @Test
    void testEvaluateNestedExpression() {
        Lexer lexer = new Lexer("(+ (* 2 3) 4)");
        List<String> tokens = lexer.tokenize();
        Parser parser = new Parser();
        ASTNode ast = parser.parse(tokens);
        Evaluator evaluator = new Evaluator();
        int result = (int) evaluator.evaluate(ast);
        assertEquals(10, result);
    }

    @Test
    void testEvaluateDivisionByZero() {
        Lexer lexer = new Lexer("(/ 1 0)");
        List<String> tokens = lexer.tokenize();
        Parser parser = new Parser();
        ASTNode ast = parser.parse(tokens);
        Evaluator evaluator = new Evaluator();
        assertThrows(ArithmeticException.class, () -> evaluator.evaluate(ast));
>>>>>>> 07d1e9dc6596b3dbdccd9789632fcd86b7c6399c
    }

}