package data.structures.queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StackTest {
    @Test
    public void testPush() {
        Stack<String> stack = new Stack<>();
        String testString = "Hello";

        String result = stack.push(testString);

        assertEquals(testString, result);
    }
}
