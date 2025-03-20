import java.util.ArrayList;
import java.util.List;

public class ASTNode {
    String type;
    String value;
    List<ASTNode> children;

    public ASTNode(String type, String value) {
        this.type = type;
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(ASTNode child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return type + "(" + value + ", " + children + ")";
    }
}
