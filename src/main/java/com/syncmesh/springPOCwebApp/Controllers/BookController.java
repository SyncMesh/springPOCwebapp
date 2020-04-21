package com.syncmesh.springPOCwebApp.Controllers;

import com.syncmesh.springPOCwebApp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//this annotation tell the program to refer the class as a controller
@Controller
public class BookController {

    //this will inject the books instance to the BookController
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //this why when we will be at /books the program will know to reference here
    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books/list";
    }
}
