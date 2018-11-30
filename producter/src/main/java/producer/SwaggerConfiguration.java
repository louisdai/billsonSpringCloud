package producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import producer.data.SwaggerConfigProperties;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Autowired
    public SwaggerConfigProperties swaggerConfig;

    @Bean
    public Docket createRestApi() {

        // 全局header
//    	ParameterBuilder aParameterBuilder = new ParameterBuilder();
//        aParameterBuilder.name("Accept").modelRef(new ModelRef("string")).parameterType("header").defaultValue("application/json").required(true).build();
//        List<Parameter> aParameters = new ArrayList<Parameter>();
//        aParameters.add(aParameterBuilder.build());
//        .globalOperationParameters(aParameters)
        return new Docket(DocumentationType.SWAGGER_2).enable(swaggerConfig.isEnable()).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerConfig.getPackageScan())).paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title(swaggerConfig.getTitle())
                .version(swaggerConfig.getVersion())
                .build();
    }
}
