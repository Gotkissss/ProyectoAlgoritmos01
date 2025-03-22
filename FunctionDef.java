import java.util.List;

public class FunctionDef {
    List<String> parameters;
    ASTNode body;

    public FunctionDef(List<String> parameters, ASTNode body) {
        this.parameters = parameters;
        this.body = body;
    }
}
