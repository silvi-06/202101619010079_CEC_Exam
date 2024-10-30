package com.example.silvi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.silvi.model.book;
import com.example.silvi.repository.repository;

@Controller
public class controller {
@Autowired

repository r1;

@PostMapping("/book/add")

public String addbook(book b1)
{
		r1.save(b1);
		return "redirect:/books/display";
}




@GetMapping("/books/display")
public String displayBook(Model model)
{
	List<book> book_list = (List<book>) r1.findAll();
	model.addAttribute("hi", book_list);
	return "display";
}


@GetMapping("/books/delete/{id}")
public String deleteBook(@PathVariable("id") Integer id)
{
	r1.deleteById(id);
	return "redirect:/books/display";
}

@GetMapping("/books/edit/{id}")
public String editBook(@PathVariable("id") Integer id, Model model) {
    book b1 = r1.findById(id).get();  
    model.addAttribute("book", b1);  
    return "edit";
}

@PostMapping("/books/edit")
public String editCar(book b2) {
    book bookDB = r1.findById(b2.getId()).get();  
    bookDB.setTitle(b2.getTitle());  
    bookDB.setAuthor(b2.getAuthor());  
    bookDB.setPrice(b2.getPrice()); 
    r1.save(bookDB);  
    return "redirect:/books/display";  
}



}
