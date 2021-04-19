package com.example.demo.conf;


import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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

//    /**
//     * swagger3的配置文件
//     */
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.OAS_30)
//                .apiInfo(apiInfo())
//                .groupName("小明童鞋demo")
//                .select()
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any())
//                .build()
//                .globalRequestParameters(getGlobalRequestParameters())
//                .globalResponses(HttpMethod.GET, getGlobalResponseMessage())
//                .globalResponses(HttpMethod.POST, getGlobalResponseMessage())
//                .globalResponses(HttpMethod.DELETE, getGlobalResponseMessage())
//                .globalResponses(HttpMethod.PUT, getGlobalResponseMessage());
//    }
//
//    /**
//     * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
//     */
//    private ApiInfo apiInfo() {
//        // 获取工程名称
//        String projectName = "小明童鞋demo";
//        return new ApiInfoBuilder()
//                .title(projectName.substring(projectName.lastIndexOf("\\") + 1) + " API接口文档")
//                .contact(new Contact("小明童鞋demo", "", "xmtx.2015@gmail.com"))
//                .version("1.5")
//                .description("API文档")
//                .build();
//    }

    @Bean
    public Docket systemApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("aspect模块")
                .genericModelSubstitutes(DeferredResult.class).useDefaultResponseMessages(false).forCodeGeneration(true)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any()).build()
                .pathMapping("/")
                .securitySchemes(Collections.singletonList(securitySchema()))
                .securityContexts(Collections.singletonList(securityContext()))
                .apiInfo(systemApiInfo());
    }

    private ApiInfo systemApiInfo() {
        return new ApiInfoBuilder()
                .title("aspect模块")
                .description("测试swagger3.0增强")
                .termsOfServiceUrl("https://www.kpmg.com/")
                .contact(new Contact("aspect模块", "", "xmtx.2015@gmail.com"))
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


    private OAuth securitySchema() {

        List<AuthorizationScope> authorizationScopeList = new ArrayList();
        //authorizationScopeList.add(new AuthorizationScope("all", "do ang"));

        List<GrantType> grantTypes = new ArrayList();
        GrantType creGrant = new ResourceOwnerPasswordCredentialsGrant("/oauth/token");

        grantTypes.add(creGrant);

        return new OAuth("oauth2schema", authorizationScopeList, grantTypes);

    }


    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.ant("/v1/api/**"))
                .build();
    }

    private List<SecurityReference> defaultAuth() {

        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[0];
        //authorizationScopes[0] = new AuthorizationScope("all", "read all");

        return Collections.singletonList(new SecurityReference("oauth2schema", authorizationScopes));
    }
}