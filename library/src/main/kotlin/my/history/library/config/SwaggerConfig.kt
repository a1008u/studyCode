package my.history.library.config

import com.google.common.base.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import springfox.documentation.service.ApiInfo

@Configuration
@EnableSwagger2
private class SwaggerConfig {

    @Bean
    fun swaggerSpringMvcPlugin(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(paths())
                .build()
                .apiInfo(apiInfo())
    }

    private fun paths(): Predicate<String> {

        // 仕様書生成対象のURLパスを指定する
        return Predicates.and(
                // 公開したくない場合に記載する
                // Predicates.not(Predicates.containsPattern("/api*")),
                Predicates.or(Predicates.containsPattern("/employee*")))
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfo(
                "spring boot2（サーバサイド）", // title
                "spring boot2 の Web API 仕様書", // description
                "0.0.1", // version
                "", // terms of service url
                "a1008u", // created by
                "a1008u Co. Ltd", // license
                "")
    }

}
