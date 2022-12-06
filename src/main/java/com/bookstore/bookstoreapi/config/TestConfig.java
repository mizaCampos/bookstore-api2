package com.bookstore.bookstoreapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.bookstore.bookstoreapi.service.DBService;


@Profile("test")
public class TestConfig {
    
    @Autowired
    DBService dbService;

    @Bean
    public void instanciarBaseDeDados(){
        this.dbService.instanciarBaseDeDados();
    }
}

//url=jdbc:h2:mem:01bee9f9-2d08-475e-ba3a-41f424ca2dcd user=SA

//jdbc:h2:mem:01bee9f9-2d08-475e-ba3a-41f424ca2dcd