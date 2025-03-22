import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ParserTest {
    @Test
<<<<<<< HEAD
    public void testParseSimpleExpression() {
        Parser parser = new Parser();
        ASTNode ast = parser.parse(List.of("(", "+", "2", "3", ")"));
=======
    void testParseSimpleExpression() {
        Lexer lexer = new Lexer("(+ 1 2)");
        List<String> tokens = lexer.tokenize();
        Parser parser = new Parser();
        ASTNode ast = parser.parse(tokens);
>>>>>>> 07d1e9dc6596b3dbdccd9789632fcd86b7c6399c
        assertEquals("expression", ast.type);
        assertEquals("+", ast.children.get(0).value);
    }

    @Test
<<<<<<< HEAD
    public void testParseAtom() {
        Parser parser = new Parser();
        ASTNode ast = parser.parse(List.of("42"));
        assertEquals("atom", ast.type);
        assertEquals("42", ast.value);
=======
    void testParseNestedExpression() {
        Lexer lexer = new Lexer("(+ (* 2 3) 4)");
        List<String> tokens = lexer.tokenize();
        Parser parser = new Parser();
        ASTNode ast = parser.parse(tokens);
        assertEquals("expression", ast.type);
        assertEquals("+", ast.children.get(0).value);
        assertEquals("expression", ast.children.get(1).type);
        assertEquals("*", ast.children.get(1).children.get(0).value);
>>>>>>> 07d1e9dc6596b3dbdccd9789632fcd86b7c6399c
    }
}
