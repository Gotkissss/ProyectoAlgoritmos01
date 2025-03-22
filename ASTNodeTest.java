import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ASTNodeTest {
    @Test
    public void testASTNodeCreation() {
        ASTNode node = new ASTNode("atom", "5");
        assertEquals("atom", node.type);
        assertEquals("5", node.value);
    }

    @Test
    public void testASTNodeChildren() {
        ASTNode parent = new ASTNode("expression", "+");
        ASTNode child = new ASTNode("atom", "2");
        parent.addChild(child);
        assertEquals(1, parent.children.size());
        assertEquals("2", parent.children.get(0).value);
    }
}
