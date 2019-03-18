package code;

import code.domain.Product;
import code.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@AllArgsConstructor
public class Application implements ApplicationRunner {
private ProductService productService;


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        System.out.println("Context bean count: " + context.getBeanDefinitionCount());
    }

    @Override
    public void run(ApplicationArguments arg0) throws Exception {

        Product product = new Product("Water", "Polyana", "gr", 20, 200, 220, 200);
        productService.addProduct(product);
        Product product2 = new Product("Phone", "Sony", "item", 20, 200, 220,200);
        productService.addProduct(product2);
    }
}