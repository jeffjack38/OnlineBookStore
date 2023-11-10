/**
 * @author jeade - jeaden
 * CIS175 - Fall 2023
 *Oct 30, 2023
 */
package jaden.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import jaden.beans.*;
import jaden.repository.BookRepository;

@Controller

public class BookController {

	@Autowired
	BookRepository repo;

	@GetMapping("list")
    public String listBooks(Model model) {
        if(repo.findAll().isEmpty()) {
        	return addBook(model);
        	}
        
        model.addAttribute("books", repo.findAll());
		return "list";
        }

	@GetMapping("/add")
	public String addBook(Model model) {
		Book b = new Book();
		model.addAttribute("newBook", b);
		return "add";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Book b = repo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT: " + b.toString());
		model.addAttribute("newBook", b);
		return "edit";
	}

	@PostMapping("/update")
	public String editBook(@ModelAttribute("newBook") Book b, Model model) {
		repo.save(b);
		return listBooks(model);
	}

	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") long id, Model model) {
		Book b = repo.findById(id).orElse(null);
		repo.delete(b);
		return listBooks(model);
	}
}