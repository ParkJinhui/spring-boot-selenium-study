package kr.co.nomadlab.springseleniumstudy.page.google;

import kr.co.nomadlab.springseleniumstudy.annotation.Page;
import kr.co.nomadlab.springseleniumstudy.page.Base;
import kr.co.nomadlab.springseleniumstudy.page.google.component.SearchComponent;
import kr.co.nomadlab.springseleniumstudy.page.google.component.SearchResultComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GooglePage extends Base {

    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResultComponent searchResultComponent;

    @Value("${application.url}")
    private String url;

    public void goTo(){
        this.driver.get(url);
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResultComponent getSearchResult() {
        return searchResultComponent;
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }

    public void close(){
        this.driver.quit();
    }
}
