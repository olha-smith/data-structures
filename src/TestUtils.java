public class TestUtils {

    public static void assertEquals(String actual, String expected) throws AssertionError {
        if (!actual.equals(expected)) throw new AssertionError();
    }

    public static void assertEquals(int actual, int expected) throws AssertionError {
        if (actual != expected) throw new AssertionError();
    }

}
