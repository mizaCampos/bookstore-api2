package com.bookstore.bookstoreapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;

import com.bookstore.bookstoreapi.service.DBService;

@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    public boolean instanciarBaseDeDados(){
        if(strategy.equals("create")){
            dbService.instanciarBaseDeDados();
        }
        return false;
    }    
}
