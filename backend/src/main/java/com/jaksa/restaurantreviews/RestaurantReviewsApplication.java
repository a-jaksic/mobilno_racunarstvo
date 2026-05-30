package com.jaksa.restaurantreviews;

import com.jaksa.restaurantreviews.files.StorageConfiguration;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageConfiguration.class)
public class RestaurantReviewsApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().directory("./backend").ignoreIfMissing().load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
        SpringApplication.run(RestaurantReviewsApplication.class, args);
    }

}
