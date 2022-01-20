package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Book;

import com.example.demo.services.bookservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bookcontroller {
    
	@Autowired
	bookservices ser;

    @PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
        return ser.savebooks(book);
	}

    @GetMapping("/findAllBooks")
	public List<Book> getBooks() {
		return ser.findAllbooks();
	}

    @DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		return ser.deleteBooks(id);
		
	}
	@PutMapping("/update/{id}/{name}")
	public String updateBookName(@PathVariable("id") int id,@PathVariable("name") String username)
	{
		return ser.updatebook(id,username);
	}
    
}
