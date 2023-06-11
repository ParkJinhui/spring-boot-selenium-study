package kr.co.nomadlab.springseleniumstudy.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Watermelon {

    @Autowired
    private Information information;

    public Information getInformation() {
        return information;
    }

    public void setAmount(int amount){
        this.information.setAmount(amount);
    }

}
