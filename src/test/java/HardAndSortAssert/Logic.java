package HardAndSortAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Logic {

    public class logic{
        @Test
        public void hardAssert(){
            Assert.assertEquals(2+2,4);
            System.out.println("test1");
            Assert.assertEquals(4+3,7);
            System.out.println("test2");
            Assert.assertEquals(3*0,0);
            System.out.println("test3");

        }
        @Test
        public void softAssert(){
            SoftAssert softAssert=new SoftAssert();
            softAssert.assertEquals(2+2,4);
            System.out.println("test4");
            softAssert.assertEquals(1+2,6);
            System.out.println("test5");
            softAssert.assertEquals(5+2,7);
            System.out.println("test6");
            softAssert.assertAll();

        }
    }
}
