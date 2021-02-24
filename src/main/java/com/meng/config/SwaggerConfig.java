package com.meng.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private Contact contact = new Contact("qy.Meng", "https://mail.qq.com/", "1148073642@qq.com");

    @Bean
    public Docket docket(Environment environment){

        Profiles profiles = Profiles.of("dev");

        //获取项目环境，如果pro不使用swagger
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("qy.Meng")
                //是否启用swagger,如果为false,就不能使用
                .enable(flag)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.meng.controller"))
                .build();
    }
    private ApiInfo apiInfo(){
       return new ApiInfo("XX接口文档",
                "联系我们",
                "v1.0",
                "https://mail.qq.com/", contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }




    }
