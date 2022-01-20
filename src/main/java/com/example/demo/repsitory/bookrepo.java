package com.example.demo.repsitory;

import com.example.demo.model.Book;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookrepo extends MongoRepository<Book,Integer>{
    
    
}
