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
    
    @Autowired
	private bookrepo repo;

    @PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
        repo.save(book);
		return "Added book with id : " + book.getId();
	}
    @GetMapping("/findAllBooks")
	public List<Book> getBooks() {
		return repo.findAll();
	}
    @DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repo.deleteById(id);
		return "book deleted with id : " + id;
	}
	@PutMapping("/update/{id}/{name}")
	public String updateBookName(@PathVariable("id") int id,@PathVariable("name") String username)
	{
		Book book=repo.findById(id).get();
		book.setName(username);
		repo.save(book);
		return "Updated name:"+username;

	}
    
}
