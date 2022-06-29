/*

package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(MessageRepository repository) {

        return args -> {
            log.info("Preloading" + repository.save(new Message("Viktiga datum för elever", "1/1-22, 3/7-22, 24/12-22", "www.csn.se/viktigadatumelever", "David Carlsson", "2022-01-01", "2022-12-12")));
            log.info("Preloading" + repository.save(new Message("Viktiga datum för studenter", "1/1-22, 3/4-22, 31/8-22", "www.csn.se/viktigadatumstudenter", "Mikolaj Wagner", "2022-01-01", "2022-12-12")));
        };
    }
}

*/