package com.dh.ddfx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.VersionResourceResolver;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author duh on 2018/6/12 16:55.
 * Email:duh@elab-plus.com
 * Version:v1.0
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = {"com.dh.ddfx.controller"}, includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})
})
public class DhSwaggerConfig extends WebMvcConfigurerAdapter{
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dh.ddfx.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("API文档").description("API文档").termsOfServiceUrl(
                "http://localhost:8095/api")
                .contact(new Contact("417865157@qq.com",
                        "http://47.96.100.43:9006/fantuo888/index.htm",
                        "417865157@qq.com")).version("2.0").build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("**/**").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("docs.html").addResourceLocations("classpath:/META-INF/resources/")
                .resourceChain(true).addResolver(new VersionResourceResolver().addFixedVersionStrategy("1.10", "/**/*.js").addContentVersionStrategy("/**"));
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/")
                .resourceChain(true).addResolver(new VersionResourceResolver().addFixedVersionStrategy("1.10", "/**/*.js").addContentVersionStrategy("/**"));
    }

}
