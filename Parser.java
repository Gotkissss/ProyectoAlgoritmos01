import java.util.List;
import java.util.Iterator;

public class Parser {
    public ASTNode parse(List<String> tokens) {
        Iterator<String> iterator = tokens.iterator();
        return parseExpression(iterator);
    }

    private ASTNode parseExpression(Iterator<String> iterator) {
        if (!iterator.hasNext()) {
            throw new RuntimeException("Expresión inválida: faltan tokens.");
        }

        String token = iterator.next();

        if (token.equals("(")) {
            ASTNode node = new ASTNode("expression", "");
            while (iterator.hasNext()) {
                String nextToken = iterator.next();
                if (nextToken.equals(")")) {
                    return node; // Cierra la expresión
                }
                node.addChild(parseExpression(new TokenIterator(nextToken, iterator)));
            }
            throw new RuntimeException("Falta paréntesis de cierre.");
        } else if (token.equals(")")) {
            throw new RuntimeException("Paréntesis de cierre inesperado.");
        } else {
            return new ASTNode("atom", token);
        }
    }

    private static class TokenIterator implements Iterator<String> {
        private final String firstToken;
        private final Iterator<String> iterator;
        private boolean firstConsumed = false;

        public TokenIterator(String firstToken, Iterator<String> iterator) {
            this.firstToken = firstToken;
            this.iterator = iterator;
        }

        @Override
        public boolean hasNext() {
            return !firstConsumed || iterator.hasNext();
        }

        @Override
        public String next() {
            if (!firstConsumed) {
                firstConsumed = true;
                return firstToken;
            }
            return iterator.next();
        }
    }
}
