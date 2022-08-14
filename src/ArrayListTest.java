class ArrayListTest {

    private static final int INITIAL_CAPACITY = 5;
    private static void testAdd_whenEmpty() {
        ArrayList<String> list = new ArrayList<>();
        String testString = "Hello";

        list.add(testString);
        String result = list.get(0);

        TestUtils.assertEquals(result,  testString);
    }

    private static void testAdd_whenNotEmpty() {
        ArrayList<String> list = new ArrayList<>();
        String testString1 = "Hello";
        String testString2 = "World";

        list.add(testString1);
        list.add(testString2);

        TestUtils.assertEquals(list.get(0), testString1);
        TestUtils.assertEquals(list.get(1), testString2);
    }

    private static void testAdd_whenFull() {
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

    private static void testAdd_withInteger() {
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

    private static void testRemove() {
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

    private static void testGet() {
        ArrayList<String> list = new ArrayList<>();
        String testString1 = "Hello";

        list.add(testString1);
        list.get(0);

    }
    public static void runTests() {
        testAdd_whenEmpty();
        testAdd_whenNotEmpty();
        testAdd_whenFull();
        testAdd_withInteger();

        testRemove();

        testSize_whenEmpty();
        testSize_whenNotEmpty();

        //todo get tests
    }
}