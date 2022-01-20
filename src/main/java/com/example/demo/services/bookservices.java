package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Book;
import com.example.demo.repsitory.bookrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class bookservices{

        @Autowired
        bookrepo repo;
        
        //Insert
        public String savebooks(Book book)
        {
            
            repo.save(book);
            return "Added book with id : " + book.getId();
        }

        //displayall
        public List<Book> findAllbooks()
        {
            return this.repo.findAll();
        }

        //deletebyid
        public String deleteBooks(int id)
        {
            repo.deleteById(id);
            return "book deleted with id : " + id;
        }

        //updatename
        public String updatebook(int id,String newname)
        {
            Book book=repo.findById(id).get();
		    book.setName(newname);
		    repo.save(book);
		    return "Updated name:"+newname;
        }

        

        



}
