package uk.gov.dhsc.htbhf.productionstub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import uk.gov.dhsc.htbhf.CommonRestConfiguration;

@SpringBootApplication
@Import(CommonRestConfiguration.class)
public class ProductionStubApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductionStubApplication.class, args);
    }

}
