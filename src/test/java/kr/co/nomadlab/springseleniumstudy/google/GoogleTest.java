package kr.co.nomadlab.springseleniumstudy.google;

import com.google.common.util.concurrent.Uninterruptibles;
import kr.co.nomadlab.springseleniumstudy.SpringBaseTestNGTest;
import kr.co.nomadlab.springseleniumstudy.page.google.GooglePage;
import kr.co.nomadlab.springseleniumstudy.utils.ScreenShotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GoogleTest extends SpringBaseTestNGTest {

    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        this.googlePage.getSearchComponent().search("spring boot ");

        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);

        this.screenShotUtil.takeScreenShot();
    }

}
