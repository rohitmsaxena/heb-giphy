package com.heb.demo.hebgiphy;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class HebGiphyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HebGiphyApplication.class, args);
//        System.out.println(new File("./resources").getAbsolutePath());\

//        ClassLoader classLoader = HebGiphyApplication.class.getClassLoader();

        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream("C:\\Users\\Rohit Saxena\\IdeaProjects\\heb-giphy\\src\\main\\resources\\hebgiphydemo-firebase-adminsdk-7xpp6-eebff97602.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FirebaseOptions options = null;
        try {
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://hebgiphydemo.firebaseio.com")
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FirebaseApp.initializeApp(options);
        List<FirebaseApp> apps = FirebaseApp.getApps();
        System.out.println(apps);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/giphy/search").allowedOrigins("http://localhost:4200");
            }
        };
    }

}
