package HW21;

public class MyTest {
    @BeforeSuite(priority = 1)
    public void beforeSuite() {
        System.out.println("Before Suite method executed");
    }

    @Test(priority = 10)
    public void test1() {
        System.out.println("Test method 1 executed");
    }

    @Test(priority = 5)
    public void test2() {
        System.out.println("Test method 2 executed");
    }

    @Test(priority = 1)
    public void test3() {
        System.out.println("Test method 3 executed");
    }

    @AfterSuite(priority = 1)
    public void afterSuite() {
        System.out.println("After Suite method executed");
    }
}
