package TestNGConcept;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {

    public int multiplication(int number1, int number2){
        return number1*number2;
    }
    @Test
    public void validationMultiplicationFunction(){
        int actual = multiplication(4,3);
        int expected = 12;
        System.out.println(actual==expected ? "TRUE" : "FALSE");
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void validateNameCointains(){
        String actual = "I love Selenium";
        String expected = "love";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void validateNotStartsWith(){
        String actual = "Ahmet";
        String expected = "Mehmet";
        Assert.assertFalse(actual.startsWith(expected));
    }
}
