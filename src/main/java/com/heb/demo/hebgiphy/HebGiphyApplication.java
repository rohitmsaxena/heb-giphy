package com.heb.demo.hebgiphy;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${firebase.database.url}")
    private static String firebaseDBUrl;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(HebGiphyApplication.class, args);

        FileInputStream serviceAccount = new FileInputStream("src/main/resources/hebgiphydemo-firebase-adminsdk-7xpp6-eebff97602.json");

        FirebaseOptions options  = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(firebaseDBUrl)
                    .build();

        FirebaseApp.initializeApp(options);
        System.out.println(FirebaseApp.getApps());
    }
}
