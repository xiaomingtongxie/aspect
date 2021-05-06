package com.example.demo.conf;


import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * swagger 配置
 *
 * @author xmtx
 */
@Configuration
@EnableOpenApi
@EnableKnife4j
public class Swagger3Config {

    @Bean
    public Docket systemApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("小明童鞋demo")
                .genericModelSubstitutes(DeferredResult.class).useDefaultResponseMessages(false).forCodeGeneration(true)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                // 这里写controller 所在的路径
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any()).build()
                .pathMapping("/")
                // 暂时不加权限认证
//                .securitySchemes(Collections.singletonList(securitySchema()))
//                .securityContexts(Collections.singletonList(securityContext()))
                .apiInfo(systemApiInfo());
    }

    private ApiInfo systemApiInfo() {
        return new ApiInfoBuilder()
                .title("小明童鞋demo")
                .description("测试swagger整合knife4j生成离线接口文档")
                .termsOfServiceUrl("https://my.oschina.net/xiaomingnevermind")
                .contact(new Contact("xmtx", "", "xmtx.2015@gmail.com"))
                .version("1.0")
                .build();
    }

    /**
     * 生成全局通用参数
     *
     * @return
     */

    private List<RequestParameter> getGlobalRequestParameters() {
        List<RequestParameter> parameters = new ArrayList<>();
        parameters.add(new RequestParameterBuilder()
                .name("x-access-token")
                .description("令牌")
                .required(false)
                .in(ParameterType.HEADER)
                .build());
        parameters.add(new RequestParameterBuilder()
                .name("Equipment-Type")
                .description("产品类型")
                .required(false)
                .in(ParameterType.HEADER)
                .build());
        return parameters;
    }

    /**
     * 生成通用响应信息
     *
     * @return
     */
    private List<Response> getGlobalResponseMessage() {
        List<Response> responseList = new ArrayList<>();
        responseList.add(new ResponseBuilder().code("404").description("找不到资源").build());
        return responseList;
    }

//
//    private OAuth securitySchema() {
//
//        List<AuthorizationScope> authorizationScopeList = new ArrayList();
//        List<GrantType> grantTypes = new ArrayList();
//        GrantType creGrant = new ResourceOwnerPasswordCredentialsGrant("/oauth/token");
//
//        grantTypes.add(creGrant);
//
//        return new OAuth("oauth2schema", authorizationScopeList, grantTypes);
//
//    }

//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .forPaths(PathSelectors.ant("/v1/api/**"))
//                .build();
//    }

    private List<SecurityReference> defaultAuth() {

        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[0];
        return Collections.singletonList(new SecurityReference("oauth2schema", authorizationScopes));
    }
}