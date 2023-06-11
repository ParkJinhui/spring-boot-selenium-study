package kr.co.nomadlab.springseleniumstudy.config;

import kr.co.nomadlab.springseleniumstudy.config.browser.BrowserScopePostProcessor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrowserScopeConfig {

    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor(){
        return new BrowserScopePostProcessor();
    }

}
