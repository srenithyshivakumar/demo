package com.example.demo.repsitory;

import com.example.demo.model.Book;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface bookrepo extends MongoRepository<Book,Integer>{
    
    
}
