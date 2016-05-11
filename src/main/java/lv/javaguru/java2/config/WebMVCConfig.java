package lv.javaguru.java2.config;

/**
 * Created by Vladislav on 3/17/2015.
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"lv.javaguru.java2"})
public class WebMVCConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/staticRes/css/**")
                .addResourceLocations("/staticRes/css/");

        registry.addResourceHandler("/staticRes/icons/**")
                .addResourceLocations("/staticRes/icons/");

        registry.addResourceHandler("/staticRes/images/**")
                .addResourceLocations("/staticRes/images/");

/*
        registry.addResourceHandler("/staticRes*//**")
         .addResourceLocations("/staticRes/css/")
         .addResourceLocations("/staticRes/icons/")
         .addResourceLocations("/staticRes/images/");*/
    }
}