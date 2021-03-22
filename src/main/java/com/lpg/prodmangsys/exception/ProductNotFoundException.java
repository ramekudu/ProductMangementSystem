package com.lpg.prodmangsys.exception;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(UUID id){
        super(String.format("There is no products for id  %s",id));
    }
}
