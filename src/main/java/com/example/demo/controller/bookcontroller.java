package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Book;
import com.example.demo.repsitory.bookrepo;

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
    
	//autoconfigure objects 
    @Autowired
	private bookrepo repo;


	//add
    @PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
        repo.save(book);
		return "Added book with id : " + book.getId();
	}

	//display
    @GetMapping("/findAllBooks")
	public List<Book> getBooks() {
		return repo.findAll();
	}

	//delete
    @DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repo.deleteById(id);
		return "book deleted with id : " + id;
	}


	//update
	@PutMapping("/update/{id}/{name}")
	public String updateBookName(@PathVariable("id") int id,@PathVariable("name") String username)
	{
		Book book=repo.findById(id).get();
		book.setName(username);
		repo.save(book);
		return "Updated name:"+username;

	}
    
}
