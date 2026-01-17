package dio.web.api.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Exemplo")
                        .version("1.0")
                        .description("Documentação da minha API usando SpringDoc"));
    }

    // eh possivel ter mais configuracoes, criar objetos para contact e license

//    .title("Title - Rest API")
//                        .description("API exemplo de uso de Springboot REST API")
//                        .version("1.0")
//                        .termsOfService("Termo de uso: Open Source")
//                        .contact(new Contact()
//                                .name("Seu Nome/Empresa")
//                                .url("http://www.seusite.com.br")
//                                .email("contato@seusite.com.br"))
//            .license(new License()
//                                .name("Licença - Sua Empresa")
//                                .url("http://www.seusite.com.br")));
}
