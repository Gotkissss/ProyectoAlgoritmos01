import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EnvironmentTest {
    @Test
    public void testSetAndGetVariable() {
        Environment env = new Environment();
        env.set("x", 10);
        assertEquals(10, env.get("x"));
    }

    @Test
    public void testGetUndefinedVariableThrowsException() {
        Environment env = new Environment();
        assertThrows(RuntimeException.class, () -> env.get("y"));
    }
}
