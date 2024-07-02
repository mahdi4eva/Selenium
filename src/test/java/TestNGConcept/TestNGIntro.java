package TestNGConcept;

import org.testng.annotations.Test;

public class TestNGIntro {

    @Test (priority = 1, invocationCount = 20) // populating data
    public void test1(){
        System.out.println("I am test 1");
    }
    @Test (priority = 3)
    public void test2(){
        System.out.println("I am test 2");
    }
    @Test (priority = 2)
    public void test3(){
        System.out.println("I am test 3");
    }


}
