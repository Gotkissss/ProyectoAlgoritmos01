import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    @Test
    void testParseSimpleExpression() {
        Lexer lexer = new Lexer("(+ 1 2)");
        List<String> tokens = lexer.tokenize();
        LispParser parser = new LispParser(tokens);
        ASTNode ast = parser.parse();
        assertEquals("list", ast.type);
        assertEquals("+", ast.children.get(0).value);
        assertEquals("1", ast.children.get(1).value);
        assertEquals("2", ast.children.get(2).value);
    }

    @Test
    void testParseNestedExpression() {
        Lexer lexer = new Lexer("(+ (* 2 3) 4)");
        List<String> tokens = lexer.tokenize();
        LispParser parser = new LispParser(tokens);
        ASTNode ast = parser.parse();
        assertEquals("list", ast.type);
        assertEquals("+", ast.children.get(0).value);
        assertEquals("list", ast.children.get(1).type);
        assertEquals("*", ast.children.get(1).children.get(0).value);
    }
}
