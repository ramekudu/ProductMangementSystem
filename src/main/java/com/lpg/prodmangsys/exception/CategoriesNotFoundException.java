package com.lpg.prodmangsys.exception;

import java.util.UUID;

public class CategoriesNotFoundException extends RuntimeException{

    public CategoriesNotFoundException(UUID id){
        super(String.format("There is no catgories for id  %s",id));
    }
}
