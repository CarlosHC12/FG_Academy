package es.etg.daw.dawes.thym.productos.infraestructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import es.etg.daw.dawes.thym.productos.application.service.CreateProductoService;
import es.etg.daw.dawes.thym.productos.application.usecase.CreateProductoUseCase;
import es.etg.daw.dawes.thym.productos.infraestructure.api.RestClientProductoAdapter;

@Configuration
public class RestClientConfig {

    //Recupero el valor del fichero application.properties
    @Value("${restclient.productos.baseurl}")
    private String productosBaseUrl;
    
    
    @Bean
    public RestClient productoRestClient() {
        return RestClient.builder()
                .baseUrl(productosBaseUrl)
                .build();
    }

    @Bean
    public CreateProductoUseCase createProductoUseCase(){
        return new CreateProductoUseCase(new RestClientProductoAdapter(productoRestClient()));

    }

    @Bean
    public CreateProductoService createProductoService(){
        return new CreateProductoService(createProductoUseCase());
    }
    

}
