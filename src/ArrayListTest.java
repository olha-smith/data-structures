class ArrayListTest {

    private static final int INITIAL_CAPACITY = 5;
    private static void testAdd_whenEmpty() throws IndexOutOfBoundsException {
        ArrayList<String> list = new ArrayList<>();
        String testString = "Hello";

        list.add(testString);
        String result = list.get(0);

        TestUtils.assertEquals(result,  testString);
    }

    private static void testAdd_whenNotEmpty() throws IndexOutOfBoundsException {
        ArrayList<String> list = new ArrayList<>();
        String testString1 = "Hello";
        String testString2 = "World";

        list.add(testString1);
        list.add(testString2);

        TestUtils.assertEquals(list.get(0), testString1);
        TestUtils.assertEquals(list.get(1), testString2);
    }

    private static void testAdd_whenFull() throws IndexOutOfBoundsException {
        ArrayList<String> list = new ArrayList<>();
        String[] expectedStrings = {"Hello", "World", "!", "I", "like", "beer"};

        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            list.add(expectedStrings[i]);
        }

        list.add(expectedStrings[INITIAL_CAPACITY]);

        for (int i = 0; i <= INITIAL_CAPACITY; i++) {
            TestUtils.assertEquals(list.get(i), expectedStrings[i]);
        }
    }

    private static void testAdd_withInteger() throws IndexOutOfBoundsException {
        ArrayList<Integer> list = new ArrayList<>();
        int testInt = 1;

        list.add(testInt);
        Integer result = list.get(0);

        TestUtils.assertEquals(result,  testInt);
    }

    private static void testSize_whenEmpty() {
        ArrayList<String> list = new ArrayList<>();
        int testInt = 0;

        int result = list.size();

        TestUtils.assertEquals(result, testInt);
    }

    private static void testSize_whenNotEmpty() {
        ArrayList<String> list = new ArrayList<>();
        int testInt = 2; // todo rename
        String testString1 = "Hello";
        String testString2 = "World";

        list.add(testString1);
        list.add(testString2);
        int result = list.size();

        TestUtils.assertEquals(result, testInt);
    }

    private static void testRemove() throws IndexOutOfBoundsException {
        ArrayList<String> list = new ArrayList<>();
        String testString1 = "Hello";
        String testString2 = "World";

        list.add(testString1);
        list.add(testString2);
        TestUtils.assertEquals(list.size(), 2);

        String result1 = list.remove(1);
        TestUtils.assertEquals(list.size(), 1);
        String result2 = list.remove(0);
        TestUtils.assertEquals(list.size(), 0);
        TestUtils.assertEquals(result1, testString2);
        TestUtils.assertEquals(result2, testString1);
    }

    //todo check that cell index: 1
    // write test for the last cell of previos array.size

    private static void testRemove_OutOfBounds() {
        ArrayList<String> list = new ArrayList<>();

        try {
            list.remove(0);
        } catch (IndexOutOfBoundsException exception) {
            TestUtils.assertNotNull(exception);
        }
    }

    private static void testGet_happyPath() throws IndexOutOfBoundsException {
        ArrayList<String> list = new ArrayList<>();
        String testString1 = "Hello";

        list.add(testString1);

        String result1 = list.get(0);
        TestUtils.assertEquals(result1, testString1);
    }

    private static void testGet_exception() {
        ArrayList<String> list = new ArrayList<>();

        try {
            list.get(0);
        } catch (IndexOutOfBoundsException exception) {
            TestUtils.assertNotNull(exception);
        }
    }
    public static void runTests() throws IndexOutOfBoundsException {
        testAdd_whenEmpty();
        testAdd_whenNotEmpty();
        testAdd_whenFull();
        testAdd_withInteger();

        testRemove();
        testRemove_OutOfBounds();

        testSize_whenEmpty();
        testSize_whenNotEmpty();

        testGet_happyPath();
        testGet_exception();

        //todo get tests
    }
}