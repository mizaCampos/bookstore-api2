package com.bookstore.bookstoreapi.resourcesExceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StandardError {

    private Long timestamp;
    private Integer status;
    private String error;
    
}
