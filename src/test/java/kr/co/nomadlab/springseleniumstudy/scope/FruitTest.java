package kr.co.nomadlab.springseleniumstudy.scope;

import kr.co.nomadlab.springseleniumstudy.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class FruitTest extends SpringBaseTestNGTest {

    @Autowired
    private Strawberry strawberry;

    @Autowired
    private Watermelon watermelon;

    @Test
    public void scopeTest(){
        this.strawberry.setAmount(100);
        System.out.println("strawberry :: " + this.strawberry.getInformation().getAmount()); // 100

        this.watermelon.setAmount(200);
        System.out.println("watermelon :: " + this.watermelon.getInformation().getAmount()); // 200

        System.out.println("strawberry :: " + this.strawberry.getInformation().getAmount()); // 100
    }


}
